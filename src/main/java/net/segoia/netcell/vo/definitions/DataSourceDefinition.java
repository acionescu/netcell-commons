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



public class DataSourceDefinition extends ConfigurableEntityDefinition{
    /**
     * 
     */
    private static final long serialVersionUID = -4024040191434629626L;

    private DataSourceType datasourceType;

    public DataSourceDefinition(){
	setType(EntitiesTypes.DATASOURCE);
    }

    /**
     * @return the datasourceType
     */
    public DataSourceType getDatasourceType() {
        return datasourceType;
    }


    /**
     * @param datasourceType the datasourceType to set
     */
    public void setDatasourceType(DataSourceType datasourceType) {
        this.datasourceType = datasourceType;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((datasourceType == null) ? 0 : datasourceType.hashCode());
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
	DataSourceDefinition other = (DataSourceDefinition) obj;
	if (datasourceType == null) {
	    if (other.datasourceType != null)
		return false;
	} else if (!datasourceType.equals(other.datasourceType))
	    return false;
	return true;
    }
    
    

}
