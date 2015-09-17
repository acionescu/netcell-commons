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

import java.util.List;

import net.segoia.netcell.vo.InputParameter;
import net.segoia.util.data.ObjectsUtil;

/**
 * This should provide an interface to pass minimal info about an executable entity
 * to a gui, in order to gather the necessary input from a user and execute a call for that entity
 * @author adi
 *
 */
public class EntityDefinitionSummary extends EntityDefinition{

    /**
     * 
     */
    private static final long serialVersionUID = 7461585712356245877L;
    
    /**
     * The id of the entity is inherited from the upper class
     */
    /**
     * The input parameters are absolutely mandatory
     * In fact this is about everything a gui needs to be able to generate a form, to gather data
     * from the user
     */
    private List<InputParameter> inputParameters;
    
    /**
     * Create an {@link EntityDefinitionSummary} from a generic {@link EntityDefinition}
     * 
     * @param def
     * @return
     * @throws Exception - when the input parameter is not of type {@link ExecutableEntityDefinition}
     */
    public static EntityDefinitionSummary createFromEntityDefinition(EntityDefinition def) throws Exception {
	if(def instanceof ExecutableEntityDefinition) {
	    ExecutableEntityDefinition eed  = (ExecutableEntityDefinition)def;
	    EntityDefinitionSummary summary = new EntityDefinitionSummary();
	    summary.setId(eed.getId());
	    summary.setType(eed.getType());
	    summary.setDescription(eed.getDescription());
	    summary.setInputParameters( (List<InputParameter>)ObjectsUtil.copy(eed.getInputParameters()));
	    return summary;
	}
	throw new Exception("Expected an ExecutableEntityDefinition but received "+def.getClass().getName());
    }
    
    /**
     * @return the inputParameters
     */
    public List<InputParameter> getInputParameters() {
        return inputParameters;
    }
    /**
     * @param inputParameters the inputParameters to set
     */
    public void setInputParameters(List<InputParameter> inputParameters) {
        this.inputParameters = inputParameters;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((inputParameters == null) ? 0 : inputParameters.hashCode());
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
	EntityDefinitionSummary other = (EntityDefinitionSummary) obj;
	if (inputParameters == null) {
	    if (other.inputParameters != null)
		return false;
	} else if (!inputParameters.equals(other.inputParameters))
	    return false;
	return true;
    }
    

}
