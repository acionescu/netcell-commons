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
package net.segoia.netcell.vo.configurations;

import java.io.Serializable;

public class ExceptionMapping implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -9030657959768424403L;
    
    private String exceptionClassName;
    
    private String mappingName;

    /**
     * @return the exceptionClassName
     */
    public String getExceptionClassName() {
        return exceptionClassName;
    }

    /**
     * @return the mappingName
     */
    public String getMappingName() {
        return mappingName;
    }

    /**
     * @param exceptionClassName the exceptionClassName to set
     */
    public void setExceptionClassName(String exceptionClassName) {
        this.exceptionClassName = exceptionClassName;
    }

    /**
     * @param mappingName the mappingName to set
     */
    public void setMappingName(String mappingName) {
        this.mappingName = mappingName;
    }
    
}
