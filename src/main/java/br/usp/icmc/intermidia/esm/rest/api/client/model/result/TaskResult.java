package br.usp.icmc.intermidia.esm.rest.api.client.model.result;

public class TaskResult extends Result {

	private static final long serialVersionUID = -3983919465067047158L;
	
	private String urlForDataFile;
	
	public TaskResult() {
		this.setType("task");
	}

	public String getUrlForDataFile() {
		return urlForDataFile;
	}

	public void setUrlForDataFile(String urlForDataFile) {
		this.urlForDataFile = urlForDataFile;
	}
	
}
