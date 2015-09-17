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
package net.segoia.netcell.vo.definitions;

import java.io.Serializable;

public class EntityDefinition implements Serializable,
	Comparable<EntityDefinition> {
    private static final long serialVersionUID = 5946883492282248859L;

    private String id;
    private String description;
    private String type;
    private EntityType entityType;

    public boolean validate() {
	// TODO : implement this
	return true;
    }

    /**
     * @return the id
     */
    public String getId() {
	return id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * @return the type
     */
    public String getType() {
	return type;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
	this.id = id;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
	this.type = type;
	this.entityType = EntityType.getEntityType(type);
    }

    /**
     * @return the entityType
     */
    public EntityType getEntityType() {
	return entityType;
    }

    /**
     * @param entityType
     *            the entityType to set
     */
    public void setEntityType(EntityType entityType) {
	this.entityType = entityType;
	this.type = entityType.getFullType();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((type == null) ? 0 : type.hashCode());
	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	EntityDefinition other = (EntityDefinition) obj;
	if (description == null) {
	    if (other.description != null)
		return false;
	} else if (!description.equals(other.description))
	    return false;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	if (type == null) {
	    if (other.type != null)
		return false;
	} else if (!type.equals(other.type))
	    return false;
	return true;
    }

    public int compareTo(EntityDefinition arg0) {
	if (arg0 == null) {
	    return -1;
	}
	if (id != null) {
	    return id.compareTo(arg0.id);
	}

	if (arg0.id == null) {
	    return 0;
	}
	return 1;
    }

}
