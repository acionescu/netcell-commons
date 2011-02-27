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
package ro.zg.netcell.vo;

import ro.zg.util.data.ObjectsUtil;

public class OutputParameter extends InputParameter{

    /**
     * 
     */
    private static final long serialVersionUID = 1654331379677726908L;
    /**
     * This property is used to specify that the type of this parameter
     * is actually the same type like an input parameter with the specified name
     * So this field will contain the name of the input parameter who's type this 
     * parameter matches
     */
    private String matchingTypeParamName;
    
    public OutputParameter(){
	
    }
    
    public OutputParameter(String name, String type){
	setName(name);
	setType(type);
    }
    
    public String getMatchingTypeParamName() {
        return matchingTypeParamName;
    }
    public void setMatchingTypeParamName(String matchingTypeParamName) {
        this.matchingTypeParamName = matchingTypeParamName;
    }
    
    public OutputParameter copy(){
	return (OutputParameter)ObjectsUtil.copy(this);
    }
    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((matchingTypeParamName == null) ? 0 : matchingTypeParamName.hashCode());
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
	OutputParameter other = (OutputParameter) obj;
	if (matchingTypeParamName == null) {
	    if (other.matchingTypeParamName != null)
		return false;
	} else if (!matchingTypeParamName.equals(other.matchingTypeParamName))
	    return false;
	return true;
    }
    
    

}
