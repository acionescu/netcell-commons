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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.segoia.netcell.constants.InputParameterLogicTypes;
import net.segoia.netcell.constants.InputParameterUiType;
import net.segoia.util.data.GenericNameValue;
import net.segoia.util.data.type.ParameterType;
import net.segoia.util.parser.ParserException;
import net.segoia.util.translation.TranslationRule;
import net.segoia.util.validation.ValidationRule;



/**
 * Defines a workflow input parameter description
 * This actually holds the definition and the restrictions of a workflow input parameter
 * Use this to add validation/translation rules and / or default values for any workflow input
 * parameter
 * @author adi
 *
 */

public class InputParameter extends GenericNameValue{

    /**
     * 
     */
    private static final long serialVersionUID = -5659791032407607733L;
    /**
     * Specifies if this parameter is mandatory
     */
    private boolean mandatory;
    
    /**
     * this should be used to indicate what type of entity this parameter represents
     * It can represent a generic value, a reference to a context parameter, a reference
     * to another flow or maybe something else
     * This can be used while populating the interface to select the right available
     * inputs for this parameter
     * @see InputParameterLogicTypes
     */
    private String logicType;
    
    /**
     * The validation rules list
     */
    private List<ValidationRule> validationRules;
    
    /**
     * The translation rules list
     */
    private List<TranslationRule> translationRules;
    
    /**
     * If more then one type for this parameter is allowed, then this property should
     * be used to specify all the permitted types. 
     * This will be used if the 'type' property is null.
     * If a generic type like 'List' or 'Context' is used then the inner type can be
     * explicitly specified or regex can be used to specify a more complex pattern
     * e.g List[Number] or  List[.*] for any type of list
     */
    private List<String> allowedTypes;
    
    private List<ParameterType> allowedParameterTypes;
    
    /** 
     * The list of possible values for this parameter 
     */
    private List<?> availableValues;
    /**
     * Ui type used to set this parameter
     * Defaults to TEXTFIELD
     * @see InputParameterUiType
     */
    private InputParameterUiType uiType = InputParameterUiType.TEXTFIELD;
    /**
     * The list of possible ui types
     */
    private List<InputParameterUiType> uiTypes;
    
    
    public InputParameter(){
	uiTypes = new ArrayList<InputParameterUiType>();
	uiTypes.addAll(Arrays.asList(InputParameterUiType.values()));
    }
    
    public InputParameter(String name,Object defaultValue,boolean mandatory,String type){
	setName(name);
	setValue(defaultValue);
	setMandatory(mandatory);
	setType(type);
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public List<ValidationRule> getValidationRules() {
        return validationRules;
    }

    public List<TranslationRule> getTranslationRules() {
        return translationRules;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public void setValidationRules(List<ValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public void setTranslationRules(List<TranslationRule> translationRules) {
        this.translationRules = translationRules;
    }
    
    public String getLogicType() {
        return logicType;
    }

    public void setLogicType(String logicType) {
        this.logicType = logicType;
    }
    
    
    /**
     * @return the allowedTypes
     */
    public List<String> getAllowedTypes() {
        return allowedTypes;
    }

    /**
     * @param allowedTypes the allowedTypes to set
     */
    public void setAllowedTypes(List<String> allowedTypes) {
        this.allowedTypes = allowedTypes;
        updateAllowedParameterTypes();
    }
    
    private void updateAllowedParameterTypes() {
	if(allowedTypes == null) {
	    return;
	}
	this.allowedParameterTypes = new ArrayList<ParameterType>();
	for(String type : allowedTypes) {
	    try {
		allowedParameterTypes.add(ParameterType.fromString(type));
	    } catch (ParserException e) {
		throw new RuntimeException("Failed to create ParemterType from string "+type,e);
	    }
	}
    }
    
    public List<String> getMatchingParams(List<GenericNameValue> candidateParams){
	List<String> params = new ArrayList<String>();
	ParameterType type = getComplexType();
	for(GenericNameValue cp : candidateParams) {
	    if(type != null && type.matches(cp.getComplexType())) {
		params.add(cp.getName());
	    }
	    else if(allowedParameterTypes != null) {
		for(ParameterType allowedType : allowedParameterTypes) {
		    if(allowedType.matches(cp.getComplexType())) {
			params.add(cp.getName());
			continue;
		    }
		}
	    }
	}
	return params;
    }
    
    /**
     * @return the availableValues
     */
    public List<?> getAvailableValues() {
        return availableValues;
    }

    /**
     * @return the uiType
     */
    public InputParameterUiType getUiType() {
        return uiType;
    }

    /**
     * @param availableValues the availableValues to set
     */
    public void setAvailableValues(List<?> availableValues) {
        this.availableValues = availableValues;
    }

    /**
     * @param uiType the uiType to set
     */
    public void setUiType(InputParameterUiType uiType) {
        this.uiType = uiType;
    }

    
    
    /**
     * @return the uiTypes
     */
    public List<InputParameterUiType> getUiTypes() {
        return uiTypes;
    }

    /**
     * @param uiTypes the uiTypes to set
     */
    public void setUiTypes(List<InputParameterUiType> uiTypes) {
        this.uiTypes = uiTypes;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((allowedTypes == null) ? 0 : allowedTypes.hashCode());
	result = prime * result + ((availableValues == null) ? 0 : availableValues.hashCode());
	result = prime * result + ((logicType == null) ? 0 : logicType.hashCode());
	result = prime * result + (mandatory ? 1231 : 1237);
	result = prime * result + ((translationRules == null) ? 0 : translationRules.hashCode());
	result = prime * result + ((uiType == null) ? 0 : uiType.hashCode());
	result = prime * result + ((uiTypes == null) ? 0 : uiTypes.hashCode());
	result = prime * result + ((validationRules == null) ? 0 : validationRules.hashCode());
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
	InputParameter other = (InputParameter) obj;
	if (allowedTypes == null) {
	    if (other.allowedTypes != null)
		return false;
	} else if (!allowedTypes.equals(other.allowedTypes))
	    return false;
	if (availableValues == null) {
	    if (other.availableValues != null)
		return false;
	} else if (!availableValues.equals(other.availableValues))
	    return false;
	if (logicType == null) {
	    if (other.logicType != null)
		return false;
	} else if (!logicType.equals(other.logicType))
	    return false;
	if (mandatory != other.mandatory)
	    return false;
	if (translationRules == null) {
	    if (other.translationRules != null)
		return false;
	} else if (!translationRules.equals(other.translationRules))
	    return false;
	if (uiType == null) {
	    if (other.uiType != null)
		return false;
	} else if (!uiType.equals(other.uiType))
	    return false;
	if (uiTypes == null) {
	    if (other.uiTypes != null)
		return false;
	} else if (!uiTypes.equals(other.uiTypes))
	    return false;
	if (validationRules == null) {
	    if (other.validationRules != null)
		return false;
	} else if (!validationRules.equals(other.validationRules))
	    return false;
	return true;
    }

}
