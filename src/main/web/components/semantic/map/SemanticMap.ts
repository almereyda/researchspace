/**
 * ResearchSpace
 * Copyright (C) 2020, © Trustees of the British Museum
 * Copyright (C) 2015-2019, metaphacts GmbH
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import { Props, createElement } from 'react';
import * as D from 'react-dom-factories';
import { findDOMNode } from 'react-dom';
import * as _ from 'lodash';
import * as maybe from 'data.maybe';

import Map from 'ol/map';
import View from 'ol/view';
import TileLayer from 'ol/layer/tile';
import VectorLayer from 'ol/layer/vector';
import Vector from 'ol/source/vector';
import Cluster from 'ol/source/cluster';
import OSM from 'ol/source/osm';
import Style from 'ol/style/style';
import Text from 'ol/style/text';
import Fill from 'ol/style/fill';
import Circle from 'ol/style/circle';
import Stroke from 'ol/style/stroke';
import Feature from 'ol/feature';
import Geometry from 'ol/geom/geometry';
import Point from 'ol/geom/point';
import MultiPoint from 'ol/geom/multipoint';
import Polygon from 'ol/geom/polygon';
import MultiPolygon from 'ol/geom/multipolygon';
import GeometryCollection from 'ol/geom/geometrycollection';
import WKT from 'ol/format/wkt';
import proj from 'ol/proj';
import control from 'ol/control';
import interaction from 'ol/interaction';
import extent from 'ol/extent';

import { BuiltInEvents, trigger } from 'platform/api/events';
import { SparqlClient, SparqlUtil } from 'platform/api/sparql';
import { Component, ComponentContext } from 'platform/api/components';

import { ErrorNotification } from 'platform/components/ui/notification';
import { Spinner } from 'platform/components/ui/spinner';
import { TemplateItem } from 'platform/components/ui/template';

import * as Popup from 'ol-popup';
import AnimatedCluster from 'ol-ext/layer/AnimatedCluster';

import 'ol/ol.css';
import 'ol-popup/src/ol-popup.css';

interface Marker {
  link?: string;
  description?: string;
}

const MIN_X = '?MinX'
const MIN_Y = '?MinY'
const MAX_X = '?MaxX'
const MAX_Y = '?MaxY'

export interface SemanticMapConfig {
  /**
   * SPARQL Select query. Query should project `lat` and `lng`, with the WKT point.
   * Or `wkt` variable with WKT point literal.
   *
   * Also to use default marker template one need to project `link` with IRI of
   * the corresponding resource and `description` with some short textual
   * marker description text.
   *
   * One can customize color of the marker/polygon using `color` projection variable
   */
  query: string;

  /**
   * <semantic-link uri='http://help.researchspace.org/resource/FrontendTemplating'>Template</semantic-link> for marker popup. By default shows `<semantic-link>` to the resource with a short textual description
   */
  tupleTemplate?: string;

  /**
   * <semantic-link uri='http://help.researchspace.org/resource/FrontendTemplating'>Template</semantic-link> which is applied when query returns no results
   */
  noResultTemplate?: string;

  /**
   * Optional numeric zoom between 0-18 (max zoom level may vary depending on the resolution)
   * to fix the inital map zoom.
   * If no fixed zoom level is provided, the zoom will be calculated on the max bounding box
   * of available markers.
   */
  fixZoomLevel?: number;

  extent?: Array<number>;

  /**
   * ID for issuing component events.
   */
  id?: string;
}

export type SemanticMapProps = SemanticMapConfig & Props<any>;

interface MapState {
  tupleTemplate?: Data.Maybe<HandlebarsTemplateDelegate>;
  errorMessage: Data.Maybe<string>;
  noResults?: boolean;
  isLoading?: boolean;
}

const MAP_REF = 'researchspace-map-widget';

export class SemanticMap extends Component<SemanticMapProps, MapState> {
  private layers: { [id: string]: VectorLayer };
  private map: Map;
  private featuresList: Array<any>;

  constructor(props: SemanticMapProps, context: ComponentContext) {
    super(props, context);
    this.state = {
      tupleTemplate: maybe.Nothing<HandlebarsTemplateDelegate>(),
      noResults: false,
      isLoading: true,
      errorMessage: maybe.Nothing<string>(),
    };

    this.featuresList = new Array<any>();
  }

  private static createPopupContent(props, tupleTemplate: Data.Maybe<HandlebarsTemplateDelegate>) {
    let defaultContent = '';

    if (_.isUndefined(props.link) === false) {
      defaultContent += `
          <semantic-link uri="${props.link}"></semantic-link>
          <p>${props.description}</p>
      `;
    }

    return tupleTemplate.map((template) => template(props)).getOrElse(defaultContent);
  }

  public componentDidMount() {
    this.createMap();
  }

  public componentWillReceiveProps(props: SemanticMapProps, context: ComponentContext) {
    if (props.query !== this.props.query) {
      this.addMarkersFromQuery(props, context);
    }
  }

  public componentWillMount() {
    this.compileTemplatesInConfig(this.props);
  }

  public render() {
    if (!this.state.errorMessage.isNothing) {
      return D.div(
        { className: 'researchspace-map-widget' },
        createElement(ErrorNotification, { errorMessage: this.state.errorMessage.get() })
      );
    } else if (this.state.tupleTemplate === undefined) {
      return createElement(Spinner);
    } else if (this.state.noResults) {
      return createElement(TemplateItem, { template: { source: this.props.noResultTemplate } });
    }
    return D.div(
      { style: { height: '100%', width: '100%' } },
      D.div(
        {
          ref: MAP_REF,
          className: 'researchspace-map-widget',
          style: {
            height: '100%',
            width: '100%',
            visibility: this.state.noResults ? 'hidden' : 'visible',
          },
        },
        D.div({
          // this div is for testing purpose only
          className: 'researchspace-map-widget-elements',
          ref: 'ref-map-widget-elements',
          onClick: this.getMarkerFromMapAsElements.bind(this),
          style: { display: 'none' },        
        })
      ),
      this.state.isLoading ? createElement(Spinner) : null
    );
  }

  private initializeMarkerPopup(map) {
    const popup = new Popup();
    map.addOverlay(popup);

    map.on('click', (evt) => {
      // Hide existing popup and reset it's offset
      popup.hide();
      popup.setOffset([0, 0]);

      // Attempt to find a feature in one of the visible vector layers
      const feature = map.forEachFeatureAtPixel(evt.pixel, function (f, layer) {
        return f;
      });

      if (feature) {
        const geometry = feature.getGeometry();
        const coord = getPopupCoordinate(geometry, evt.coordinate);
        const { features = [feature] } = feature.getProperties();

        const popupContent = features.map((feature) => {
          const props = feature.getProperties();
          return `<div>${SemanticMap.createPopupContent(props, this.state.tupleTemplate)}</div>`;
        });

        // info += "<p>" + props.locationtext + "</p>";
        // Offset the popup so it points at the middle of the marker not the tip
        popup.setOffset([0, -22]);
        popup.show(coord, `<mp-template-item>${popupContent.join('')}</mp-template-item>`);
      }
    });

    map.on('pointermove', (e) => {
      const hasFeatureAtPixel = map.hasFeatureAtPixel(e.pixel);
      map.getTarget().style.cursor = hasFeatureAtPixel ? 'pointer' : '';
    });
  }

  private transformToMercator(lng: number, lat: number): [number, number] {
    return proj.transform([lng, lat], 'EPSG:4326', 'EPSG:3857');
  }

  private readWKT(wkt: string) {
    const format = new WKT();
    return format.readGeometry(wkt, {
      dataProjection: 'EPSG:3857',
      featureProjection: 'EPSG:3857',
    });
  }

  private createGeometries = (markersData: any[]) => {
    const geometries: { [type: string]: Feature[] } = {};

    markersData.forEach((marker) => {
      const f = new Feature(marker);
      let geo: Geometry = undefined;
      if (!_.isUndefined(marker['lat']) && !_.isUndefined(marker['lng'])) {
        geo = new Point(this.transformToMercator(parseFloat(marker['lng'].value), parseFloat(marker['lat'].value)));
      } else if (!_.isUndefined(marker['wkt']) && _.isUndefined(geo)) {
        geo = this.readWKT(marker['wkt'].value);
      }

      if (_.isUndefined(geo)) {
        const msg = `Result of SPARQL Select query does have neither
                    lat,lng nor wkt projection variable. `;
        this.setState({ errorMessage: maybe.Just(msg) });
      } else {
        f.setGeometry(geo);

        const type = geo.getType();
        geometries[type] = geometries[type] ? [...geometries[type], f] : [f];
      }
    });

    return geometries;
  };

  private createLayer = (features: Feature[], type: string): VectorLayer => {
    const source = new Vector({ features });
    if (type === 'Point') {
      const clusterSource = new Cluster({ source, distance: 40 });
      return new AnimatedCluster({
        source: clusterSource,
        style: getMarkerStyle(),
        zIndex: 1, // we want to always have markers on top of polygons
      });
    }
    return new VectorLayer({
      source,
      style: (feature: Feature) => {
        const geometry = feature.getGeometry();
        const color = feature.get('color');
        return getFeatureStyle(geometry, 'rgba(77, 175, 124, .5)');
      },
      zIndex: 0,
    });
  };

  private renderMap(node, props, center, markers) {
    window.setTimeout(() => {
      const geometries = this.createGeometries(markers);
      const layers = _.mapValues(geometries, this.createLayer);

      const map = new Map({
        controls: control.defaults({
          attributionOptions: {
            collapsible: false,
          },
        }),
        interactions: interaction.defaults({ mouseWheelZoom: false }),
        layers: [
          new TileLayer({
            source: new OSM(),
          }),
          ..._.values(layers),
        ],
        target: node,
        view: new View({
          center: this.transformToMercator(parseFloat(center.lng), parseFloat(center.lat)),
          zoom: 3,
          extent:props.extent
        }),
      });

      this.layers = layers;
      this.map = map;

      // asynch execute query and add markers
      this.addMarkersFromQuery(this.props, this.context);

      this.initializeMarkerPopup(map);
      map.getView().fit(props.extent);

      window.addEventListener('resize', () => {
        map.updateSize();
      });

      //this.map.on('moveend', () => {
        //this.addMarkersFromQuery(this.props, this.context)
      //})

      //this.map.on('singleclick', (e) =>{
      //  console.log(e)
      //})

      const view = this.map.getView();
      const extent = this.calculateExtent();
      view.fit(extent, { maxZoom: 10 });

    }, 1000);
  }

  filterList = (date?: number) => {

    if (date)
      return _.filter(this.featuresList, (v) => (typeof v.end_date == 'undefined' ? 
      Date.parse(v.start_date.value) < date : 
      Date.parse(v.start_date.value) < date && Date.parse(v.end_date.value) >= date) ); //&& !v.bw_id.value.startsWith('SS_IS')

    else
      return this.featuresList;
  }
  
  addMarkersFromQuery = (props: SemanticMapProps, context: ComponentContext, date?: number) => {
    let { query } = props;

    if (!date) date = Date.parse('1850-01-01')

    const bbCoords = this.map.getView().calculateExtent(this.map.getSize())

    // TODO: refine this passage
    query = query.replace(MIN_X, `"${bbCoords[0]}"`)
    query = query.replace(MIN_Y, `"${bbCoords[1]}"`)
    query = query.replace(MAX_X, `"${bbCoords[2]}"`)
    query = query.replace(MAX_Y, `"${bbCoords[3]}"`)

    if (query) {
      const stream = SparqlClient.select(query, { context: context.semanticContext });
      
      stream.onValue((res) => {

        this.featuresList = _.map(res.results.bindings, (v) => _.mapValues(v, (x) => x) as any);

        const filteredList = this.filterList(date);

        if (SparqlUtil.isSelectResultEmpty(res)) {
          this.setState({
            noResults: true,
            errorMessage: maybe.Nothing<string>(),
            isLoading: false,
          });
        } else {
          this.setState({
            noResults: false,
            errorMessage: maybe.Nothing<string>(),
            isLoading: false,
          });

          const geometries = this.createGeometries(filteredList);
          this.updateLayers(geometries);
        }

        if (this.props.id){
          trigger({ eventType: BuiltInEvents.ComponentLoaded, source: this.props.id, data: {results: filteredList}});
        }
      });

      stream.onError((error) =>
        this.setState({
          errorMessage: maybe.Just(error),
          isLoading: false,
        })
      );

      stream.onEnd(() => {
        /*
        if (this.props.id) {
          trigger({ eventType: BuiltInEvents.ComponentLoaded, source: this.props.id});
        }*/
      });

      if (this.props.id) {
        trigger({
          eventType: BuiltInEvents.ComponentLoading,
          source: this.props.id,
          data: stream,
        });
      }
    }
  };

  private updateLayers = (geometries: { [type: string]: Feature[] }) => {
    _.forEach(geometries, (features, type) => {
      let layer = this.layers[type];

      if (layer) {
        let source = layer.getSource();
        if (source instanceof Cluster) {
          source = source.getSource();
        }
        source.clear();
        source.addFeatures(features);
      } else {
        layer = this.createLayer(features, type);
        this.layers[type] = layer;
        this.map.addLayer(layer);
      }
    });
  };

  private calculateExtent() {
    const viewExtent = extent.createEmpty();

    _.forEach(this.layers, (layer) => {
      let source = layer.getSource();
      if (source instanceof Cluster) {
        source = source.getSource();
      }
      extent.extend(viewExtent, source.getExtent());
    });

    return viewExtent;
  }

  private createMap = () => {
    this.renderMap(
      findDOMNode(this.refs[MAP_REF]),
      this.props,
      {
        lng: parseFloat('0'),
        lat: parseFloat('0'),
      },
      []
    );
  };

  private getMarkerFromMapAsElements = () => {
    if (!_.isUndefined(this.layers)) {
      _.forEach(this.layers, (layer) => {
        const elementDiv = this.refs['ref-map-widget-elements'];
        let source = layer.getSource();
        if (source instanceof Cluster) {
          source = source.getSource();
        }
        const features = source.getFeaturesInExtent(source.getExtent());
        const d = findDOMNode(elementDiv);
        const template = this.state.tupleTemplate;

        _.forEach(features, (f) => {
          const html = SemanticMap.createPopupContent(f.getProperties(), template);
          const doc = new DOMParser().parseFromString(html, 'text/html');
          d.appendChild(doc.body.firstChild);
        });
      });
    }
  };

  private compileTemplatesInConfig = (config: SemanticMapConfig): void => {
    const defaultTemplate = `
        <semantic-link class="map-resource-link" data-uri="{{link.value}}">
        </semantic-link>
        <p>{{description.value}}</p>
    `;

    const template = maybe
      .fromNullable(this.handleDeprecatedLayout(config))
      .chain((tupleTemplate) => maybe.fromNullable(tupleTemplate))
      .getOrElse(defaultTemplate);

    this.appliedTemplateScope
      .compile(template)
      .then((tupleTemplate) => {
        this.setState({
          tupleTemplate: maybe.Just(tupleTemplate),
          errorMessage: maybe.Nothing<string>(),
        });
      })
      .catch((error) => {
        this.setState({ errorMessage: maybe.Just(error) });
      });
  };

  private handleDeprecatedLayout(props: SemanticMapConfig): string {
    if (_.has(props, 'layout')) {
      console.warn('layout property in semantic-map is deprecated, please use flat properties instead');
      return props['layout']['tupleTemplate'];
    } else {
      return props.tupleTemplate;
    }
  }
}

function getMarkerStyle() {
  const styleCache = {};

  const clusterStyle = (size, radius, color) =>
    new Style({
      image: new Circle({
        radius,
        fill: new Fill({ color }),
      }),
      text: new Text({
        text: size.toString(),
        fill: new Fill({ color: '#fff' }),
      }),
    });

  return function (feature: Feature) {
    const features = feature.get('features');
    const size = features.length;

    const { value: color } = features[0].get('color') || { value: '#000' };

    let style = styleCache[`${size}${color}`];
    if (!style) {
      if (size === 1) {
        const geometry = feature.getGeometry();
        style = getFeatureStyle(geometry, color);
      } else {
        const radius = Math.max(8, Math.min(size * 0.75, 20));
        style = clusterStyle(size, radius, color);
      }

      styleCache[size] = style;
    }
    return [style];
  };
}

function getFeatureStyle(geometry: Geometry, color: string | undefined) {
  if (geometry instanceof Point || geometry instanceof MultiPoint) {
    return new Style({
      geometry,
      text: new Text({
        text: '\uf041',
        font: 'normal 22px FontAwesome',
        textBaseline: 'bottom',
        fill: new Fill({ color: color || '#000' }),
      }),
    });
  } else if (geometry instanceof GeometryCollection) {
    return geometry.getGeometries().map((geom) => getFeatureStyle(geom, color));
  }
  return new Style({
    geometry,
    fill: new Fill({ color: color || 'rgba(255, 255, 255, 0.5)' }),
    stroke: new Stroke({
      color: color || 'rgba(202, 105, 36, .3)',
      width: 1.25,
    }),
  });
}

function getPopupCoordinate(geometry: Geometry, coordinate: [number, number]) {
  if (geometry instanceof Point) {
    return geometry.getCoordinates();
  }
  if (geometry instanceof Polygon) {
    return geometry.getInteriorPoint().getCoordinates();
  } else if (geometry instanceof MultiPolygon) {
    const polygons = geometry.getPolygons();
    for (let i = 0; i < polygons.length; i++) {
      const polygon = polygons[i];
      if (polygon.intersectsCoordinate(coordinate)) {
        return getPopupCoordinate(polygon, coordinate);
      }
    }
  } else if (geometry instanceof GeometryCollection) {
    const geometries = geometry.getGeometries();
    for (let i = 0; i < geometries.length; i++) {
      const geometry = geometries[i];
      if (geometry.intersectsCoordinate(coordinate)) {
        return getPopupCoordinate(geometry, coordinate);
      }
    }
  }
  return geometry.getClosestPoint(coordinate);
}

export default SemanticMap;
