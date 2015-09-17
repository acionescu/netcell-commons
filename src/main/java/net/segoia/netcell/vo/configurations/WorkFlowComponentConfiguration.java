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
import java.util.HashMap;
import java.util.Map;

public class WorkFlowComponentConfiguration implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 3710515079509703241L;
    private String localId;
    private ComponentConfiguration componentConfig;
    private ComponentExitPointsMapping componentMapping;
    private ComponentExitPoint errorMapping;
    /**
     * The mappings for the output parameters of this component </br> key - the actual name of the output parameter
     * </br> value - the name under which this parameter will be mapped on the global context
     */
    private Map<String, String> outputParamsMappings = new HashMap<String, String>();
    /**
     * The name under which the whole component response will be saved on the global context
     */
    private String outputParamName;

    public ComponentConfiguration getComponentConfig() {
	return componentConfig;
    }

    public ComponentExitPointsMapping getComponentMapping() {
	return componentMapping;
    }

    public void setComponentConfig(ComponentConfiguration componentConfig) {
	this.componentConfig = componentConfig;
    }

    public void setComponentMapping(ComponentExitPointsMapping componentMapping) {
	this.componentMapping = componentMapping;
    }

    public Map<String, String> getOutputParamsMappings() {
	return outputParamsMappings;
    }

    public void setOutputParamsMappings(Map<String, String> outputParamsMappings) {
	this.outputParamsMappings = outputParamsMappings;
    }

    public String getOutputParamName() {
	return outputParamName;
    }

    public void setOutputParamName(String outputParamName) {
	this.outputParamName = outputParamName;
    }

    public String getLocalId() {
	return localId;
    }

    public void setLocalId(String localId) {
	this.localId = localId;
    }

    /**
     * @return the errorMapping
     */
    public ComponentExitPoint getErrorMapping() {
	return errorMapping;
    }

    /**
     * @param errorMapping
     *            the errorMapping to set
     */
    public void setErrorMapping(ComponentExitPoint errorMapping) {
	this.errorMapping = errorMapping;
    }

    public void renameReferenceToComponent(String oldId, String newId) {
	if (componentConfig != null) {
	    componentMapping.renameReferenceToComponent(oldId, newId);
	}
	if (errorMapping != null) {
	    errorMapping.renameReferenceToComponent(oldId, newId);
	}
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
	result = prime * result + ((componentConfig == null) ? 0 : componentConfig.hashCode());
	result = prime * result + ((componentMapping == null) ? 0 : componentMapping.hashCode());
	result = prime * result + ((errorMapping == null) ? 0 : errorMapping.hashCode());
	result = prime * result + ((localId == null) ? 0 : localId.hashCode());
	result = prime * result + ((outputParamName == null) ? 0 : outputParamName.hashCode());
	result = prime * result + ((outputParamsMappings == null) ? 0 : outputParamsMappings.hashCode());
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
	WorkFlowComponentConfiguration other = (WorkFlowComponentConfiguration) obj;
	if (componentConfig == null) {
	    if (other.componentConfig != null)
		return false;
	} else if (!componentConfig.equals(other.componentConfig))
	    return false;
	if (componentMapping == null) {
	    if (other.componentMapping != null)
		return false;
	} else if (!componentMapping.equals(other.componentMapping))
	    return false;
	if (errorMapping == null) {
	    if (other.errorMapping != null)
		return false;
	} else if (!errorMapping.equals(other.errorMapping))
	    return false;
	if (localId == null) {
	    if (other.localId != null)
		return false;
	} else if (!localId.equals(other.localId))
	    return false;
	if (outputParamName == null) {
	    if (other.outputParamName != null)
		return false;
	} else if (!outputParamName.equals(other.outputParamName))
	    return false;
	if (outputParamsMappings == null) {
	    if (other.outputParamsMappings != null)
		return false;
	} else if (!outputParamsMappings.equals(other.outputParamsMappings))
	    return false;
	return true;
    }

}
