package br.usp.icmc.intermidia.esm.rest.api.client.model.intervention;

public class TaskIntervention extends Intervention {
	
	private static final long serialVersionUID = -5178905488082755947L;
	
	public static final String URL_FOR_DATA_FILE = "urlForDataFile";
	
	private String appPackage;
	
	public TaskIntervention() {
		this.setType("task");
	}

	public String getAppPackage() {
		return appPackage;
	}

	public void setAppPackage(String appPackage) {
		this.appPackage = appPackage;
	}

}
