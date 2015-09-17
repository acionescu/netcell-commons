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
package ro.zg.netcell.constants;

import java.util.Date;

public enum InputParameterType {
    String,
    Number,
    Boolean,
    Date,
    List,
    Context,
    Any;
    
    public static String[] valuesAsStringArray(){
	InputParameterType[] values = values();
	String[] stringArray = new String[values.length];
	for(int i=0;i<values.length;i++){
	    stringArray[i] = values[i].toString();
	}
	return stringArray;
    }
    
    public static Class toJavaClass(String type) {
	if(type.equals("String") || type.startsWith("List") || type.startsWith("Context")) {
	    return String.class;
	}
	if(type.equals("Number")) {
	    return Float.class;
	}
	if(type.equals("Boolean")) {
	    return Boolean.class;
	}
	if(type.equals("Date")) {
	    return Date.class;
	}
	return null;
    }
}