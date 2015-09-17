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
import java.util.ArrayList;
import java.util.List;

public class EntityType implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 7174721086049966547L;

    private static final String separator = "/";

    private EntityType parentType;
//    private Map<String, EntityType> children = new LinkedHashMap<String, EntityType>();
    private EntityType childType;
    private String type;
    private String fullType;
    
    public EntityType() {

    }

    public EntityType(String type) {
	this.type = type;
    }

    public EntityType(String type, EntityType parent) {
	this.type = type;
	setParent(parent);
    }

    public static EntityType getEntityType(String fullType) {
	String[] typesHierarchy = fullType.split(separator);
	return getEntityType(typesHierarchy);
    }
    /**
     * hierarchy of the types, root node must come first
     * @param typesHierarchy
     * @return the last type
     */
    public static EntityType getEntityType(String... typesHierarchy) {
	EntityType parent = null, current = null;
	for (String s : typesHierarchy) {
	    current = new EntityType(s, parent);
	    parent = current;
	}
	return current;
    }

    /**
     * @return the parentType
     */
    public EntityType getParentType() {
	return parentType;
    }

    /**
     * @return the type
     */
    public String getType() {
	return type;
    }

    /**
     * @return the fullType
     */
    public String getFullType() {
	return fullType;
    }

    public void setParent(EntityType parentType) {
	this.parentType = parentType;
	if (parentType != null) {
//	    parentType.addChildType(this);
	    parentType.setChildType(this);
	}
    }

//    public void addChildType(EntityType entityType) {
//	children.put(entityType.getType(), entityType);
//    }
    
    public EntityType getRoot(){
	if(parentType == null){
	    return this;
	}
	return parentType.getRoot();
    }
    
    public List<String> getHierarchyAsList(){
	List<String> h = null;
	if(parentType == null){
	    h = new ArrayList<String>();
	    h.add(type);
	    return h;
	}
	h = parentType.getHierarchyAsList();
	h.add(type);
	return h;
    }

    /**
     * @return the childType
     */
    public EntityType getChildType() {
        return childType;
    }

    /**
     * @param childType the childType to set
     */
    public void setChildType(EntityType childType) {
        this.childType = childType;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((childType == null) ? 0 : childType.hashCode());
	result = prime * result + ((fullType == null) ? 0 : fullType.hashCode());
	result = prime * result + ((parentType == null) ? 0 : parentType.hashCode());
	result = prime * result + ((type == null) ? 0 : type.hashCode());
	return result;
    }

    /* (non-Javadoc)
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
	EntityType other = (EntityType) obj;
	if (childType == null) {
	    if (other.childType != null)
		return false;
	} else if (!childType.equals(other.childType))
	    return false;
	if (fullType == null) {
	    if (other.fullType != null)
		return false;
	} else if (!fullType.equals(other.fullType))
	    return false;
	if (parentType == null) {
	    if (other.parentType != null)
		return false;
	} else if (!parentType.equals(other.parentType))
	    return false;
	if (type == null) {
	    if (other.type != null)
		return false;
	} else if (!type.equals(other.type))
	    return false;
	return true;
    }
    
}
