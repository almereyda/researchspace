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

package org.researchspace.rest.endpoint;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.eclipse.rdf4j.repository.RepositoryException;
import org.researchspace.rest.feature.CacheControl.NoCache;
import org.researchspace.services.URLMinifierService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Endpoint for 301 redirects on short /l/XXXXX links
 * 
 * @author Denis Ostapenko
 */
@Path("")
public class URLMinifierRedirectEndpoint {
    private static final Logger logger = LogManager.getLogger(URLMinifierRedirectEndpoint.class);

    @Context
    private UriInfo uri;

    @Inject
    private URLMinifierService urlMinifierService;

    @GET()
    @NoCache
    @Path("{path: .*}")
    public Response redirect(@Context HttpRequest httpRequest) throws RepositoryException, URISyntaxException {
        String shortURL = uri.getPath();
        if (shortURL.length() < URLMinifierService.KEY_LENGTH) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        String key = shortURL.substring(shortURL.length() - URLMinifierService.KEY_LENGTH);
        String url = urlMinifierService.queryDBByKey(key);
        if (url == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.MOVED_PERMANENTLY).location(new URI(url)).build();
    }
}
