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

public class ConfigurableComponentDefinition extends ComponentDefinition{

    /**
     * 
     */
    private static final long serialVersionUID = 2972333201396694102L;
    
    private ConfigurationData configData = new ConfigurationData();

    /**
     * The id of the template used to create this component
     */
    private String templateId;
    
    
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
    
    /**
     * @return the templateId
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * @param templateId the templateId to set
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((configData == null) ? 0 : configData.hashCode());
	result = prime * result + ((templateId == null) ? 0 : templateId.hashCode());
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
	ConfigurableComponentDefinition other = (ConfigurableComponentDefinition) obj;
	if (configData == null) {
	    if (other.configData != null)
		return false;
	} else if (!configData.equals(other.configData))
	    return false;
	if (templateId == null) {
	    if (other.templateId != null)
		return false;
	} else if (!templateId.equals(other.templateId))
	    return false;
	return true;
    }
    
}
