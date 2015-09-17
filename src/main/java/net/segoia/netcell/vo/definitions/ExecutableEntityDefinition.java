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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.segoia.netcell.vo.InputParameter;
import net.segoia.netcell.vo.OutputParameter;
import net.segoia.netcell.vo.configurations.FixedExitPoints;
import net.segoia.util.data.ObjectsUtil;
import net.segoia.util.strings.MatchHandler;
import net.segoia.util.strings.ParamsReplacer;

public abstract class ExecutableEntityDefinition extends EntityDefinition{
    /**
     * 
     */
    private static final long serialVersionUID = -21086971266220262L;
    private static ParamsReplacer replacer = new ParamsReplacer("\\(.*\\)");
    
    private List<InputParameter> inputParameters = new ArrayList<InputParameter>();
    private List<OutputParameter> outputParameters = new ArrayList<OutputParameter>();
    private Map<String,InputParameter> inputParametersMap = new LinkedHashMap<String, InputParameter>();
    private Map<String,OutputParameter> outputParametersMap = new LinkedHashMap<String, OutputParameter>();
    
    private FixedExitPoints fixedExitPoints;
    /**
     * Used to populate instance properties from map
     */
    protected transient Map<String,Object> definitionParams;
    
    public void init(){
	if(definitionParams ==null){
	    return;
	}
	List<InputParameter> inputParams = (List<InputParameter>)definitionParams.get("inputParameters");
	if(inputParams != null){
	    setInputParameters(inputParams);
	}
	List<OutputParameter> outputParams = (List<OutputParameter>)definitionParams.get("outputParameters");
	if(outputParams != null){
	    setOutputParameters(outputParams);
	}
	
	fixedExitPoints = (FixedExitPoints)definitionParams.get("fixedExitPoints"); 
	
	definitionParams = null;
    }
    
    
    public abstract List<String> getMapableExitParams();
    
    public abstract Map<String, List<String>> getPossibleValuesForExitParam();
    

    public List<OutputParameter> getOutputParamsForInputParams(Map<String, InputParameter> input) {
	List<OutputParameter> response = (List<OutputParameter>)ObjectsUtil.copy(getOutputParameters());
	for (OutputParameter op : response) {
	    if (op.getType() == null) {
		String matchingRule = op.getMatchingTypeParamName();
		if (matchingRule != null) {
		    op.setType(getTypeForMatchingRule(matchingRule,input));
		}
	    }
	}
	return response;
    }

    private String getTypeForMatchingRule(String rule, final Map<String, InputParameter> input) {
	String r = replacer.replace(rule, new MatchHandler() {
	    public String onMatch(String paramName) {
		Object value = input.get(paramName).getValue();
		if (value != null) {
		    return value.toString();
		}
		return null;
	    }
	});

	if (r != null) {
	    int i = r.indexOf(".");
	    if (i > 0) {
		String ipName = r.substring(0, i);
		return input.get(ipName).getTypeForMatchingRule(r.substring(i + 1));
	    }
	    else{
		return input.get(r).getType();
	    }
	}
	return null;
    }

    
    public List<String> getOutputParameterNames() {
	List<String> op = new ArrayList<String>();
	for (OutputParameter p : outputParameters) {
	    op.add(p.getName());
	}
	return op;
    }
    
    public List<InputParameter> getInputParameters() {
        return inputParameters;
    }
    public List<OutputParameter> getOutputParameters() {
        return outputParameters;
    }
   
    public void setInputParameters(List<InputParameter> inputParameters) {
        this.inputParameters = inputParameters;
        inputParametersMap.clear();
        if(inputParameters != null){
            for(InputParameter ip : inputParameters){
        	inputParametersMap.put(ip.getName(), ip);
            }
        }
    }
    public void setOutputParameters(List<OutputParameter> outputParameters) {
        this.outputParameters = outputParameters;
        outputParametersMap.clear();
        if(outputParameters != null){
            for(OutputParameter op : outputParameters){
        	outputParametersMap.put(op.getName(), op);
            }
        }
    }
    public Map<String, Object> getDefinitionParams() {
        return definitionParams;
    }
    public void setDefinitionParams(Map<String, Object> definitionParams) {
        this.definitionParams = definitionParams;
    }
    

    /**
     * @return the inputParametersMap
     */
    public Map<String, InputParameter> getInputParametersMap() {
        return inputParametersMap;
    }

    /**
     * @return the outputParametersMap
     */
    public Map<String, OutputParameter> getOutputParametersMap() {
        return outputParametersMap;
    }
    
    

    /**
     * @return the fixedExitPoints
     */
    public FixedExitPoints getFixedExitPoints() {
        return fixedExitPoints;
    }


    /**
     * @param fixedExitPoints the fixedExitPoints to set
     */
    public void setFixedExitPoints(FixedExitPoints fixedExitPoints) {
        this.fixedExitPoints = fixedExitPoints;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((fixedExitPoints == null) ? 0 : fixedExitPoints.hashCode());
	result = prime * result + ((inputParameters == null) ? 0 : inputParameters.hashCode());
	result = prime * result + ((inputParametersMap == null) ? 0 : inputParametersMap.hashCode());
	result = prime * result + ((outputParameters == null) ? 0 : outputParameters.hashCode());
	result = prime * result + ((outputParametersMap == null) ? 0 : outputParametersMap.hashCode());
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
	ExecutableEntityDefinition other = (ExecutableEntityDefinition) obj;
	if (fixedExitPoints == null) {
	    if (other.fixedExitPoints != null)
		return false;
	} else if (!fixedExitPoints.equals(other.fixedExitPoints))
	    return false;
	if (inputParameters == null) {
	    if (other.inputParameters != null)
		return false;
	} else if (!inputParameters.equals(other.inputParameters))
	    return false;
	if (inputParametersMap == null) {
	    if (other.inputParametersMap != null)
		return false;
	} else if (!inputParametersMap.equals(other.inputParametersMap))
	    return false;
	if (outputParameters == null) {
	    if (other.outputParameters != null)
		return false;
	} else if (!outputParameters.equals(other.outputParameters))
	    return false;
	if (outputParametersMap == null) {
	    if (other.outputParametersMap != null)
		return false;
	} else if (!outputParametersMap.equals(other.outputParametersMap))
	    return false;
	return true;
    }
    
    
}
