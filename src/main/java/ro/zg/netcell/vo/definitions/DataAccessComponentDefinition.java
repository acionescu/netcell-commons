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

import java.util.Map;

public class DataAccessComponentDefinition extends ConfigurableComponentDefinition{

    /**
     * 
     */
    private static final long serialVersionUID = -8728918595930963924L;
    
    public static final String COMMAND_CONTENT="COMMAND_CONTENT";
    public static final String COMMAND_TYPE="COMMAND_TYPE";

    
    
    private String dataSourceName;
    private DataSourceType dataSourceType;    
    private String commandName;
    private String commandType;
    
    public DataAccessComponentDefinition(){
	setType(EntitiesTypes.DATA_ACCESS_COMPONENT);
    }
    
    public void init(){
	if (definitionParams == null) {
	    return;
	}
	Map<String,String> nestedDataCompConfig = (Map)definitionParams.get("executionEntity");
	this.commandName = nestedDataCompConfig.get("commandName");
	this.dataSourceName = nestedDataCompConfig.get("commandManager");
	super.init();
	
    }

    /**
     * @return the dataSourceName
     */
    public String getDataSourceName() {
        return dataSourceName;
    }

    /**
     * @return the commandName
     */
    public String getCommandName() {
        return commandName;
    }

    /**
     * @param dataSourceName the dataSourceName to set
     */
    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }

    /**
     * @param commandName the commandName to set
     */
    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    /**
     * @return the dataSourceType
     */
    public DataSourceType getDataSourceType() {
        return dataSourceType;
    }

    /**
     * @param dataSourceType the dataSourceType to set
     */
    public void setDataSourceType(DataSourceType dataSourceType) {
        this.dataSourceType = dataSourceType;
    }
    
    /**
     * @return the commandType
     */
    public String getCommandType() {
        return commandType;
    }

    /**
     * @param commandType the commandType to set
     */
    public void setCommandType(String commandType) {
        this.commandType = commandType;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((commandName == null) ? 0 : commandName.hashCode());
	result = prime * result + ((commandType == null) ? 0 : commandType.hashCode());
	result = prime * result + ((dataSourceName == null) ? 0 : dataSourceName.hashCode());
	result = prime * result + ((dataSourceType == null) ? 0 : dataSourceType.hashCode());
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
	DataAccessComponentDefinition other = (DataAccessComponentDefinition) obj;
	if (commandName == null) {
	    if (other.commandName != null)
		return false;
	} else if (!commandName.equals(other.commandName))
	    return false;
	if (commandType == null) {
	    if (other.commandType != null)
		return false;
	} else if (!commandType.equals(other.commandType))
	    return false;
	
	if (dataSourceName == null) {
	    if (other.dataSourceName != null)
		return false;
	} else if (!dataSourceName.equals(other.dataSourceName))
	    return false;
	if (dataSourceType == null) {
	    if (other.dataSourceType != null)
		return false;
	} else if (!dataSourceType.equals(other.dataSourceType))
	    return false;
	return true;
    }
    
}
