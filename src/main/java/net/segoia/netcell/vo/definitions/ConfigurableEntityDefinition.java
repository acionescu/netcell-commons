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

import ro.zg.util.data.ConfigurationData;

public class ConfigurableEntityDefinition extends EntityDefinition{

    /**
     * 
     */
    private static final long serialVersionUID = -7089880685941205063L;
    
    private ConfigurationData configData;
    
    public Object getConfigParamValue(String paramName) {
	return configData.getParameterValue(paramName);
    }

    /**
     * @return the configData
     */
    public ConfigurationData getConfigData() {
        return configData;
    }

    /**
     * @param configData the configData to set
     */
    public void setConfigData(ConfigurationData configData) {
        this.configData = configData;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((configData == null) ? 0 : configData.hashCode());
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
	ConfigurableEntityDefinition other = (ConfigurableEntityDefinition) obj;
	if (configData == null) {
	    if (other.configData != null)
		return false;
	} else if (!configData.equals(other.configData))
	    return false;
	return true;
    }
    
    

}
