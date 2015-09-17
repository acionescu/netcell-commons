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
package net.segoia.netcell.vo.configurations;

import java.io.Serializable;
import java.util.Arrays;
/**
 * Used to define mappings for the component exit points
 * Possible types of mappings are:
 * LABEL - marks the exit with a label (this means the flow terminates here)
 * COMPONENT - specifies the id of the next component to be executed for a specific exit of the current component
 * @author adi
 *
 */
public class ComponentExitPoint implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -8716356315436402912L;
    public static final String LABEL="LABEL";
    public static final String COMPONENT="COMPONENT";
    
    private String[] mappingTypes = {LABEL,COMPONENT};
    private String mappingType = LABEL;
    
    private String exitPointName;
    /**
     * The label for this exitPoint
     */
    private String exitPointMapping;
    /**
     * The id of the next component to be called
     */
    private String nextComponentId;
    
    public boolean isExitPoint(){
	return (exitPointMapping != null);
    }
    
    public String getExitPointMapping() {
        return exitPointMapping;
    }
    public String getNextComponentId() {
        return nextComponentId;
    }
    public void setExitPointMapping(String exitPointMapping) {
        this.exitPointMapping = exitPointMapping;
        if(exitPointMapping != null){
            mappingType = LABEL;
        }
    }
    public void setNextComponentId(String nextComponentId) {
        this.nextComponentId = nextComponentId;
        if(nextComponentId != null){
            mappingType = COMPONENT;
        }
    }

    public String getMappingType() {
        return mappingType;
    }

    public void setMappingType(String mappingType) {
        this.mappingType = mappingType;
    }

    public String[] getMappingTypes() {
        return mappingTypes;
    }

    /**
     * @param mappingTypes the mappingTypes to set
     */
    public void setMappingTypes(String[] mappingTypes) {
        this.mappingTypes = mappingTypes;
    }

    public String getExitPointName() {
        return exitPointName;
    }

    public void setExitPointName(String exitPointName) {
        this.exitPointName = exitPointName;
    }
    
    public String toString() {
	return mappingType +" "+ nextComponentId + " " + exitPointMapping;
    }

    public void renameReferenceToComponent(String oldId, String newId) {
	if(oldId.equals(nextComponentId)) {
	    nextComponentId = newId;
	}
    }
    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((exitPointMapping == null) ? 0 : exitPointMapping.hashCode());
	result = prime * result + ((exitPointName == null) ? 0 : exitPointName.hashCode());
	result = prime * result + ((mappingType == null) ? 0 : mappingType.hashCode());
	result = prime * result + Arrays.hashCode(mappingTypes);
	result = prime * result + ((nextComponentId == null) ? 0 : nextComponentId.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	ComponentExitPoint other = (ComponentExitPoint) obj;
	if (exitPointMapping == null) {
	    if (other.exitPointMapping != null)
		return false;
	} else if (!exitPointMapping.equals(other.exitPointMapping))
	    return false;
	if (exitPointName == null) {
	    if (other.exitPointName != null)
		return false;
	} else if (!exitPointName.equals(other.exitPointName))
	    return false;
	if (mappingType == null) {
	    if (other.mappingType != null)
		return false;
	} else if (!mappingType.equals(other.mappingType))
	    return false;
	if (!Arrays.equals(mappingTypes, other.mappingTypes))
	    return false;
	if (nextComponentId == null) {
	    if (other.nextComponentId != null)
		return false;
	} else if (!nextComponentId.equals(other.nextComponentId))
	    return false;
	return true;
    }
    
}
