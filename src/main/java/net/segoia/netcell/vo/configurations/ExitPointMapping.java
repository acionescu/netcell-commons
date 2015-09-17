/*******************************************************************************
 * Copyright 2011 Adrian Cristian Ionescu
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package ro.zg.netcell.vo.configurations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ro.zg.util.data.GenericNameValueContext;

public class ExitPointMapping implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 4519915729476549526L;

    public static final String NO_MAPPING = "NO_MAPPING";
    public static final String DIRECT_MAPPING = "DIRECT_MAPPING";
    public static final String PARAMETER_MAPPING = "PARAMETER_MAPPING";
    public static final String FIXED_MAPPINGS ="FIXED_MAPPINGS";

    private String[] mappingTypes = { NO_MAPPING, DIRECT_MAPPING };
    private String mappingType = NO_MAPPING;
    private String exitLabel;
    private String nextComponentId;
    private String exitPointPrmName;
   
    private Map<Object, ComponentExitPoint> exitValuesMappings = new LinkedHashMap<Object, ComponentExitPoint>();

    private Map<Object, ComponentExitPoint> fixedMappings = new LinkedHashMap<Object, ComponentExitPoint>();
    
    public void renameReferenceToComponent(String oldId, String newId) {
	if(oldId.equals(nextComponentId)) {
	    nextComponentId = newId;
	}
	for(ComponentExitPoint cep : exitValuesMappings.values()) {
	    cep.renameReferenceToComponent(oldId, newId);
	}
	for(ComponentExitPoint cep : fixedMappings.values()) {
	    cep.renameReferenceToComponent(oldId, newId);
	}
    }
    
    public ComponentExitPoint getExitPoint(GenericNameValueContext context) {
	Object value = context.getValue(exitPointPrmName);
	return exitValuesMappings.get(value);
    }

    public List<String> getExitLabelsList() {
	List<String> list = new ArrayList<String>();
	if (mappingType.equals(NO_MAPPING) && exitLabel != null) {
	    list.add(exitLabel);
	} else if (mappingType.equals(PARAMETER_MAPPING)) {
	    for (ComponentExitPoint ep : exitValuesMappings.values()) {
		if (ep.getMappingType().equals(ComponentExitPoint.LABEL)) {
		    if (ep.getExitPointMapping() != null) {
			list.add(ep.getExitPointMapping());
		    }
		}
	    }
	}
	return list;
    }

    public String getNextComponentId() {
	return nextComponentId;
    }

    public String getExitPointPrmName() {
	return exitPointPrmName;
    }

    public Map<Object, ComponentExitPoint> getExitValuesMappings() {
	return exitValuesMappings;
    }

    public void setNextComponentId(String nextComponentId) {
	this.nextComponentId = nextComponentId;
	if (nextComponentId != null) {
	    mappingType = DIRECT_MAPPING;
	}
    }

    public void setExitPointPrmName(String exitPointPrmName) {
	this.exitPointPrmName = exitPointPrmName;
	if (exitPointPrmName != null) {
	    mappingType = PARAMETER_MAPPING;
	}
    }

    public void setExitValuesMappings(Map<Object, ComponentExitPoint> exitValuesMappings) {
	this.exitValuesMappings = exitValuesMappings;
	if (exitValuesMappings != null) {
	    for (Map.Entry<Object, ComponentExitPoint> e : exitValuesMappings.entrySet()) {
		e.getValue().setExitPointName(e.getKey().toString());
	    }
	}
    }

    public String getMappingType() {
	return mappingType;
    }

    public void setMappingType(String mappingType) {
	this.mappingType = mappingType;
	if (NO_MAPPING.equals(mappingType)) {
	    nextComponentId = null;
	    exitPointPrmName = null;
	    exitValuesMappings.clear();
	}
    }

    public String[] getMappingTypes() {
	return mappingTypes;
    }

    public void setSimpleMappingTypes() {
	mappingTypes = new String[] { NO_MAPPING, DIRECT_MAPPING };
    }

    public void setComplexMappingTypes() {
	mappingTypes = new String[] { NO_MAPPING, DIRECT_MAPPING, PARAMETER_MAPPING };
    }

    public void setFixedMappingTypes() {
	mappingTypes = new String[] {FIXED_MAPPINGS};
    }
    
    public String getExitLabel() {
	return exitLabel;
    }

    public void setExitLabel(String exitLabel) {
	this.exitLabel = exitLabel;
    }
    
    

    /**
     * @return the fixedMappings
     */
    public Map<Object, ComponentExitPoint> getFixedMappings() {
        return fixedMappings;
    }

    /**
     * @param fixedMappings the fixedMappings to set
     */
    public void setFixedMappings(Map<Object, ComponentExitPoint> fixedMappings) {
        this.fixedMappings = fixedMappings;
        mappingType = FIXED_MAPPINGS;
        setFixedMappingTypes();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((exitLabel == null) ? 0 : exitLabel.hashCode());
	result = prime * result + ((exitPointPrmName == null) ? 0 : exitPointPrmName.hashCode());
	result = prime * result + ((exitValuesMappings == null) ? 0 : exitValuesMappings.hashCode());
	result = prime * result + ((mappingType == null) ? 0 : mappingType.hashCode());
	result = prime * result + Arrays.hashCode(mappingTypes);
	result = prime * result + ((nextComponentId == null) ? 0 : nextComponentId.hashCode());
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
	ExitPointMapping other = (ExitPointMapping) obj;
	if (exitLabel == null) {
	    if (other.exitLabel != null)
		return false;
	} else if (!exitLabel.equals(other.exitLabel))
	    return false;
	if (exitPointPrmName == null) {
	    if (other.exitPointPrmName != null)
		return false;
	} else if (!exitPointPrmName.equals(other.exitPointPrmName))
	    return false;
	if (exitValuesMappings == null) {
	    if (other.exitValuesMappings != null)
		return false;
	} else if (!exitValuesMappings.equals(other.exitValuesMappings))
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
