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

import ro.zg.netcell.vo.OutputParameter;
import ro.zg.netcell.vo.configurations.WorkFlowComponentConfiguration;
import ro.zg.netcell.vo.configurations.WorkFlowConfiguration;
import ro.zg.util.data.GenericNameValue;
import ro.zg.util.data.ObjectsUtil;

public class WorkFlowDefinition extends ExecutableEntityDefinition {
    /**
     * 
     */
    private static final long serialVersionUID = -3357133567272432345L;
    private WorkFlowConfiguration workFlowConfig;
    private List<GenericNameValue> localParameters = new ArrayList<GenericNameValue>();
    private List<GenericNameValue> defaultParametersList;
    public static final String WORKFLOW_EXIT_POINT_LABEL = "exit";

    public WorkFlowDefinition() {
	setType("workflow-definition");
	defaultParametersList = new ArrayList<GenericNameValue>();
	defaultParametersList.add(new OutputParameter(WORKFLOW_EXIT_POINT_LABEL,"String"));
    }

    public void init() {
	if (definitionParams == null) {
	    return;
	}
	List<GenericNameValue> localParams = (List<GenericNameValue>) definitionParams.get("localParameters");
	if (localParams != null) {
	    setLocalParameters(localParams);
	}
	workFlowConfig = (WorkFlowConfiguration) definitionParams.get("executionEntity");
	super.init();
    }

    public boolean validate() {
	super.validate();
	// TODO : implement this
	return true;
    }
    
    public List<GenericNameValue> getContextParamsList() {
	List<GenericNameValue> cpl = new ArrayList<GenericNameValue>();
	cpl.addAll((List)ObjectsUtil.copy(getInputParameters()));
	cpl.addAll((List)ObjectsUtil.copy(getLocalParameters()));
	return cpl;
    }
    
    public List<OutputParameter> getPossibleOutputParameters(){
	List<OutputParameter> pop = new ArrayList<OutputParameter>();
	for(GenericNameValue gp : getInputParameters()){
	    pop.add(new OutputParameter(gp.getName(),gp.getType()));
	}
	for(GenericNameValue gp : getLocalParameters()){
	    pop.add(new OutputParameter(gp.getName(),gp.getType()));
	}
	return pop;
    }
    
    public Map<String,GenericNameValue> getContextParamsMap(){
	Map<String, GenericNameValue> cpm = new LinkedHashMap<String, GenericNameValue>();
	for(GenericNameValue ip : getContextParamsList()){
	    cpm.put(ip.getName(), ip);
	}
	return cpm;
    }
    

    @Override
    public List<String> getMapableExitParams() {
	List<String> list = new ArrayList<String>();
	/* for now return only the exit point as a mappable parameter */
	list.add(WORKFLOW_EXIT_POINT_LABEL);
	return list;
    }
    

    @Override
    public Map<String, List<String>> getPossibleValuesForExitParam() {
	Map<String,List<String>> resp = new LinkedHashMap<String, List<String>>();
	resp.put(WORKFLOW_EXIT_POINT_LABEL, workFlowConfig.getExitLabelsList());
	return resp;
    }
    
    public List<String> getDependencies(){
	List<String> dependencies = new ArrayList<String>();
	for(WorkFlowComponentConfiguration wfc : workFlowConfig.getComponents().values()){
	    dependencies.add(wfc.getComponentConfig().getComponent());
	}
	return dependencies;
    }
    
    public WorkFlowConfiguration getWorkFlowConfig() {
	return workFlowConfig;
    }

    public void setWorkFlowConfig(WorkFlowConfiguration workFlowConfig) {
	this.workFlowConfig = workFlowConfig;
    }

    public List<GenericNameValue> getDefaultParametersList() {
	return (List<GenericNameValue>)ObjectsUtil.copy(defaultParametersList);
    }

    public List<GenericNameValue> getLocalParameters() {
	return localParameters;
    }

    public void setLocalParameters(List<GenericNameValue> localParameters) {
	this.localParameters = localParameters;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((localParameters == null) ? 0 : localParameters.hashCode());
	result = prime * result + ((workFlowConfig == null) ? 0 : workFlowConfig.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	WorkFlowDefinition other = (WorkFlowDefinition) obj;
	if (localParameters == null) {
	    if (other.localParameters != null)
		return false;
	} else if (!localParameters.equals(other.localParameters))
	    return false;
	if (workFlowConfig == null) {
	    if (other.workFlowConfig != null)
		return false;
	} else if (!workFlowConfig.equals(other.workFlowConfig))
	    return false;
	return true;
    }

}
