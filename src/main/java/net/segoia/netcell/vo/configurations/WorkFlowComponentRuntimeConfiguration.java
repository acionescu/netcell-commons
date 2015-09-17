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
package ro.zg.netcell.vo.configurations;

import java.io.Serializable;
import java.util.Map;

import ro.zg.netcell.entities.GenericEntity;
import ro.zg.util.data.GenericNameValueContext;

public class WorkFlowComponentRuntimeConfiguration implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 5471955132559239895L;
    private GenericEntity<GenericNameValueContext> component;
    private ComponentExitPointsMapping mapping;
    private ComponentExitPoint errorMapping;
    private Map<String,String> outputParamsMappings;
    /**
     * The name under which the whole component response will be saved on the global context
     */
    private String outputParamName;
    
    public GenericEntity<GenericNameValueContext> getComponent() {
        return component;
    }
    public ComponentExitPointsMapping getMapping() {
        return mapping;
    }
    public void setComponent(GenericEntity<GenericNameValueContext> component) {
        this.component = component;
    }
    public void setMapping(ComponentExitPointsMapping mapping) {
        this.mapping = mapping;
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
    /**
     * @return the errorMapping
     */
    public ComponentExitPoint getErrorMapping() {
        return errorMapping;
    }
    /**
     * @param errorMapping the errorMapping to set
     */
    public void setErrorMapping(ComponentExitPoint errorMapping) {
        this.errorMapping = errorMapping;
    }
    
}
