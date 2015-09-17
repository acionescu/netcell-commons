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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WorkFlowConfiguration implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 438020028854859327L;
    private String id;
    private String entryPointId;
    private Map<String, WorkFlowComponentConfiguration> components = new LinkedHashMap<String, WorkFlowComponentConfiguration>();
    private transient Map<String, Object> workflowParams;

    public void init() {
	if (workflowParams == null) {
	    return;
	}
	entryPointId = (String) workflowParams.get("defaultEntryPointId");
	components = (Map<String, WorkFlowComponentConfiguration>) workflowParams.get("components");
	workflowParams = null;
    }

    public void removeComponentWithId(String id) {
	if (id == null || components == null || !components.containsKey(id)) {
	    return;
	}
	components.remove(id);
	for (WorkFlowComponentConfiguration wc : components.values()) {
	    ComponentExitPointsMapping cm = wc.getComponentMapping();
	    if (id.equals(cm.getNextComponentId())) {
		cm.setMappingType(ComponentExitPointsMapping.NO_MAPPING);
	    } else if (cm.getMappingType().equals(ComponentExitPointsMapping.PARAMETER_MAPPING)) {
		for (ComponentExitPoint cep : cm.getExitValuesMappings().values()) {
		    if (id.equals(cep.getNextComponentId())) {
			cep.setNextComponentId(null);
			cep.setMappingType(ComponentExitPoint.LABEL);
			cep.setExitPointMapping(cep.getExitPointName());
		    }
		}
	    }
	}
	if (id.equals(entryPointId)) {
	    if (components.size() > 0) {
		entryPointId = (String) components.keySet().toArray()[0];
	    } else {
		entryPointId = null;
	    }
	}
    }

    public List<String> getExitLabelsList() {
	/* return only unique exit labels, and order them alphabetically */
	Set<String> set = new TreeSet<String>();
	if (components == null || components.size() == 0) {
	    return new ArrayList<String>();
	}

	// for(WorkFlowComponentConfiguration wfc : components.values()){
	for (Map.Entry<String, WorkFlowComponentConfiguration> entry : components.entrySet()) {
	    WorkFlowComponentConfiguration wfc = entry.getValue();
	    System.out.println(entry.getKey() + ": " + wfc.getComponentMapping().getExitLabelsList());
	    set.addAll(wfc.getComponentMapping().getExitLabelsList());
	}
	return new ArrayList<String>(set);
    }

    public List<String> getComponentsIds() {
	return new ArrayList(components.keySet());
    }

    public String getId() {
	return id;
    }

    public String getEntryPointId() {
	return entryPointId;
    }

    public Map<String, WorkFlowComponentConfiguration> getComponents() {
	return components;
    }

    public void setId(String id) {
	this.id = id;
    }

    public void setEntryPointId(String entryPointId) {
	this.entryPointId = entryPointId;
    }

    public void setComponents(Map<String, WorkFlowComponentConfiguration> components) {
	this.components = components;
    }

    public Map<String, Object> getWorkflowParams() {
	return workflowParams;
    }

    public void setWorkflowParams(Map<String, Object> workflowParams) {
	this.workflowParams = workflowParams;
    }

    public void renameWorkflowComponent(String oldLocalId, String newLocalId) {
	/* rename the targeted component */
	WorkFlowComponentConfiguration wfc = components.remove(oldLocalId);
	wfc.setLocalId(newLocalId);
	components.put(newLocalId, wfc);
	/* replace the old name with the new, in all the references to it */
	for (WorkFlowComponentConfiguration currentWfc : components.values()) {
	    currentWfc.renameReferenceToComponent(oldLocalId, newLocalId);
	}
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((components == null) ? 0 : components.hashCode());
	result = prime * result + ((entryPointId == null) ? 0 : entryPointId.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
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
	WorkFlowConfiguration other = (WorkFlowConfiguration) obj;
	if (components == null) {
	    if (other.components != null)
		return false;
	} else if (!components.equals(other.components))
	    return false;
	if (entryPointId == null) {
	    if (other.entryPointId != null)
		return false;
	} else if (!entryPointId.equals(other.entryPointId))
	    return false;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }

}
