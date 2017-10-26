package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

public class TaskResult extends Result {

	private static final long serialVersionUID = -3983919465067047158L;

	private long task;
	
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

	public long getTask() {
		return task;
	}

	public void setTask(long task) {
		this.task = task;
	}
	
}
