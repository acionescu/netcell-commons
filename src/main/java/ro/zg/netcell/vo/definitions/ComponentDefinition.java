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
package ro.zg.netcell.vo.definitions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ComponentDefinition extends ExecutableEntityDefinition {
    private static final long serialVersionUID = 2321301911203305446L;

    private Map<String, String> simpleResponseMappings = new LinkedHashMap<String, String>();
    private Map<String, Map<String, String>> complexResponseMappings = new LinkedHashMap<String, Map<String, String>>();

    
    
    public void init() {
	if (definitionParams == null) {
	    return;
	}
	/* get the simple and complex responses mappings */
	Object staticObject = definitionParams.get("executionEntity");
	if (staticObject instanceof Map) {
	    Map<String, Object> staticConfigParams = (Map<String, Object>) staticObject;
	    if (staticConfigParams != null) {
		simpleResponseMappings = (Map<String, String>) staticConfigParams.get("simpleResponseWithMappings");
	    }
	}
	/* extract the rest of the parameters */
	super.init();
    }

    public List<String> getMapableExitParams() {
	List<String> validParamNames = new ArrayList<String>();
	if (simpleResponseMappings != null && simpleResponseMappings.size() > 0) {
	    String mappedParamName = getOutputParameters().get(0).getName();
	    validParamNames.add(mappedParamName);

	} else {
	    // TODO: check form complex response mappings
	}
	return validParamNames;
    }

    public Map<String, List<String>> getPossibleValuesForExitParam() {
	Map<String, List<String>> values = new LinkedHashMap<String, List<String>>();
	if (simpleResponseMappings != null && simpleResponseMappings.size() > 0) {
	    String paramName = getOutputParameters().get(0).getName();
	    values.put(paramName, new ArrayList(simpleResponseMappings.values()));
	} else {
	    // TODO: do it for complex params
	}
	return values;
    }

    public Map<String, String> getSimpleResponseMappings() {
	return simpleResponseMappings;
    }

    public void setSimpleResponseMappings(Map<String, String> simpleResponseMappings) {
	this.simpleResponseMappings = simpleResponseMappings;
    }

    public Map<String, Map<String, String>> getComplexResponseMappings() {
	return complexResponseMappings;
    }

    public void setComplexResponseMappings(Map<String, Map<String, String>> complexResponseMappings) {
	this.complexResponseMappings = complexResponseMappings;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((complexResponseMappings == null) ? 0 : complexResponseMappings.hashCode());
	result = prime * result + ((simpleResponseMappings == null) ? 0 : simpleResponseMappings.hashCode());
	return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	ComponentDefinition other = (ComponentDefinition) obj;
	if (complexResponseMappings == null) {
	    if (other.complexResponseMappings != null)
		return false;
	} else if (!complexResponseMappings.equals(other.complexResponseMappings))
	    return false;
	if (simpleResponseMappings == null) {
	    if (other.simpleResponseMappings != null)
		return false;
	} else if (!simpleResponseMappings.equals(other.simpleResponseMappings))
	    return false;
	return true;
    }

}
