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

public class ScheduledJobDefinition extends ConfigurableEntityDefinition{

    /**
     * 
     */
    private static final long serialVersionUID = 4518122547926549360L;
    
    public static final String FLOW_ID="FLOW_ID";
    public static final String FLOW_INPUT_PARAMS="FLOW_INPUT_PARAMS";
    public static final String CRON_TRIGGER="CRON_TRIGGER";
    public static final String ALLOWED_CONCURENT_JOBS="ALLOWED_CONCURENT_JOBS";
    public static final String MISSFIRE_INSTRUCTION="MISSFIRE_INSTRUCTION";
    public static final String MISSFIRE_VALUE="MISSFIRE_VALUE";
    public static final String ACTIVE="ACTIVE";
    
    public ScheduledJobDefinition() {
	setType(EntitiesTypes.SCHEDULED_JOB);
    }

}
