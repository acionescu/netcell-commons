/**
 * netcell-commons - Shared support classes for netcell ecosystem
 * Copyright (C) 2009  Adrian Cristian Ionescu - https://github.com/acionescu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.segoia.netcell.entities;

import net.segoia.util.data.GenericNameValueContext;
import net.segoia.util.execution.ExecutionEntity;

public abstract class GenericEntity<O> implements ExecutionEntity<GenericNameValueContext, O>{

    /**
     * 
     */
    private static final long serialVersionUID = -4421883635293014787L;
    
    private String id;
    /**
     * an integer value representing the type of this entity
     * this does not have a specific value, it can be used as is needed
     */
    private int entityType;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public int getEntityType() {
        return entityType;
    }

    /**
     * @param type the type to set
     */
    public void setEntityType(int type) {
        this.entityType = type;
    }
}
