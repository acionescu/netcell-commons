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
package net.segoia.netcell.vo;

import java.util.List;

public class InputParameterConfig extends InputParameter {
    /**
     * 
     */
    private static final long serialVersionUID = 1740730224143435526L;
    public static final String DEFAULT = "DEFAULT";
    public static final String EMPTY = "EMPTY";
    public static final String STATIC = "STATIC";
    public static final String DYNAMIC = "DYNAMIC";
    
    
    
    private Object defaultValue;
//    private List<?> availableValues;
    private String configType;
    private List<String> configTypes;
    
    public InputParameterConfig() {

    }

    public InputParameterConfig(InputParameter p) {
	setName(p.getName());
	setMandatory(p.isMandatory());
	setTranslationRules(p.getTranslationRules());
	setValidationRules(p.getValidationRules());
	setValue(p.getValue());
	setDefaultValue(p.getValue());
    }

    public Object getDefaultValue() {
	return defaultValue;
    }

    public String getConfigType() {
	return configType;
    }

    public List<String> getConfigTypes() {
	return configTypes;
    }

    public void setDefaultValue(Object defaultValue) {
	this.defaultValue = defaultValue;
    }

    public void setConfigType(String configType) {
	this.configType = configType;
    }

    public void setConfigTypes(List<String> configTypes) {
	this.configTypes = configTypes;
    }

//    public List<?> getAvailableValues() {
//        return availableValues;
//    }
//
//    public void setAvailableValues(List<?> availableValues) {
//        this.availableValues = availableValues;
//    }

}
