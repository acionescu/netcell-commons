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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FixedExitPoints implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -7029509940345711725L;
    private List<String> allowedMappingTypes = new ArrayList<String>();
    private List<String> exitLabels = new ArrayList<String>();

    /**
     * Get the fixed exit points as a map to be easily set on the {@link ComponentExitPointsMapping} fixedMappings field
     * one can also restrict the type of mapping for the exit points,
     * if nothing specified, then the default will be used @see {@link ComponentExitPoint}
     * @return
     */
    public Map<Object, ComponentExitPoint> asMap() {
	Map<Object, ComponentExitPoint> map = new LinkedHashMap<Object, ComponentExitPoint>();
	if (exitLabels != null) {
	    String[] mappingTypes = null;
	    if (allowedMappingTypes != null) {
		mappingTypes = allowedMappingTypes.toArray(new String[0]);
	    }
	    for (String exitLabel : exitLabels) {
		ComponentExitPoint cep = new ComponentExitPoint();
		if (mappingTypes != null) {
		    cep.setMappingTypes(mappingTypes);
		    cep.setMappingType(mappingTypes[0]);
		}
		map.put(exitLabel, cep);
	    }
	}
	return map;
    }

    /**
     * @return the allowedMappingTypes
     */
    public List<String> getAllowedMappingTypes() {
	return allowedMappingTypes;
    }

    /**
     * @return the exitLabels
     */
    public List<String> getExitLabels() {
	return exitLabels;
    }

    /**
     * @param allowedMappingTypes
     *            the allowedMappingTypes to set
     */
    public void setAllowedMappingTypes(List<String> allowedMappingTypes) {
	this.allowedMappingTypes = allowedMappingTypes;
    }

    /**
     * @param exitLabels
     *            the exitLabels to set
     */
    public void setExitLabels(List<String> exitLabels) {
	this.exitLabels = exitLabels;
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
	result = prime * result + ((allowedMappingTypes == null) ? 0 : allowedMappingTypes.hashCode());
	result = prime * result + ((exitLabels == null) ? 0 : exitLabels.hashCode());
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
	FixedExitPoints other = (FixedExitPoints) obj;
	if (allowedMappingTypes == null) {
	    if (other.allowedMappingTypes != null)
		return false;
	} else if (!allowedMappingTypes.equals(other.allowedMappingTypes))
	    return false;
	if (exitLabels == null) {
	    if (other.exitLabels != null)
		return false;
	} else if (!exitLabels.equals(other.exitLabels))
	    return false;
	return true;
    }

}
