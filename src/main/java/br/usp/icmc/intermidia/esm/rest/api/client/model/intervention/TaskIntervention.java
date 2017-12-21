package br.usp.icmc.intermidia.esm.rest.api.client.model.intervention;

import java.util.HashMap;
import java.util.Map;

public class TaskIntervention extends Intervention {
	
	private static final long serialVersionUID = -5178905488082755947L;
	
	public static final String URL_FOR_DATA_FILE = "urlForDataFile";
	
	private String appPackage;
	
	private Map<String, String> parameters = new HashMap<>();
	
	public TaskIntervention() {
		this.setType("task");
	}

	public String getAppPackage() {
		return appPackage;
	}

	public void setAppPackage(String appPackage) {
		this.appPackage = appPackage;
	}
	
	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

}
