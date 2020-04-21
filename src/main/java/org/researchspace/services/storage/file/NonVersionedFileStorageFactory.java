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

package org.researchspace.services.storage.file;

import org.apache.commons.configuration2.Configuration;
import org.researchspace.services.storage.api.*;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Johannes Trame <jt@metaphacts.com>
 */
public class NonVersionedFileStorageFactory implements StorageFactory {
    @Override
    public String getStorageType() {
        return NonVersionedFileStorage.STORAGE_TYPE;
    }

    @Override
    public StorageConfig parseStorageConfig(String storageType, Configuration properties)
            throws StorageConfigException {
        NonVersionedFileStorage.Config config = new NonVersionedFileStorage.Config();
        StorageConfig.readBaseProperties(config, properties);
        if (properties.containsKey("root")) {
            Path root = Paths.get(properties.getString("root"));
            config.setRoot(root);
        }
        return config;
    }
}