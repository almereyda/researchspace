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

package org.researchspace.rest;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;

import org.glassfish.hk2.api.ServiceLocator;
import org.researchspace.rest.endpoint.RDFGraphStoreEndpoint;

/**
 * @author Johannes Trame <jt@metaphacts.com>
 */
@ApplicationPath("rdf-graph-store")
public class RDFGraphStoreApplication extends AbstractPlatformApplication {

    @Inject
    public RDFGraphStoreApplication(ServiceLocator serviceLocator) {
        super(serviceLocator);
        register(RDFGraphStoreEndpoint.class);
    }

}