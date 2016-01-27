package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import java.net.URI;
import java.sql.Blob;

public class TaskResult extends Result {

	private URI task;
	
	private Blob resultData;

	public URI getTask() {
		return task;
	}

	public void setTask(URI task) {
		this.task = task;
	}

	public Blob getResultData() {
		return resultData;
	}

	public void setResultData(Blob resultData) {
		this.resultData = resultData;
	}
	
}
