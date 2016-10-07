package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import java.net.URI;

public class TaskResult extends Result {

	private URI task;
	
	private String urlForDataFile;
	
	public TaskResult() {
		this.setType("task");
	}

	protected URI getTask() {
		return task;
	}

	protected void setTask(URI task) {
		this.task = task;
	}

	public String getUrlForDataFile() {
		return urlForDataFile;
	}

	public void setUrlForDataFile(String urlForDataFile) {
		this.urlForDataFile = urlForDataFile;
	}
	
}
