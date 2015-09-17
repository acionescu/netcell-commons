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
import java.util.LinkedHashMap;
import java.util.Map;

import ro.zg.util.data.ValueType;

public class ComponentConfiguration implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 8622962607260684257L;
    private Map<String,ValueType> staticInputParams = new LinkedHashMap<String, ValueType>();
    private Map<String,String> dynamicInputParams = new LinkedHashMap<String, String>();
    private String component;
    
    
    public Map<String, ValueType> getStaticInputParams() {
        return staticInputParams;
    }
    public Map<String, String> getDynamicInputParams() {
        return dynamicInputParams;
    }
   
    public void setStaticInputParams(Map<String, ValueType> staticInputParams) {
        this.staticInputParams = staticInputParams;
    }
    public void setDynamicInputParams(Map<String, String> dynamicInputParams) {
        this.dynamicInputParams = dynamicInputParams;
    }
   
    public String getComponent() {
        return component;
    }
    public void setComponent(String component) {
        this.component = component;
    }
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((component == null) ? 0 : component.hashCode());
	result = prime * result + ((dynamicInputParams == null) ? 0 : dynamicInputParams.hashCode());
	result = prime * result + ((staticInputParams == null) ? 0 : staticInputParams.hashCode());
	return result;
    }
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	ComponentConfiguration other = (ComponentConfiguration) obj;
	if (component == null) {
	    if (other.component != null)
		return false;
	} else if (!component.equals(other.component))
	    return false;
	if (dynamicInputParams == null) {
	    if (other.dynamicInputParams != null)
		return false;
	} else if (!dynamicInputParams.equals(other.dynamicInputParams))
	    return false;
	if (staticInputParams == null) {
	    if (other.staticInputParams != null)
		return false;
	} else if (!staticInputParams.equals(other.staticInputParams))
	    return false;
	return true;
    }
    
}
