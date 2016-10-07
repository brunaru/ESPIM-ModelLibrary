package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import java.net.URI;

public class SensorResult extends Result {

	private URI sensor;
	
	private String urlForDataFile;
	
	public SensorResult() {
		this.setType("sensor");
	}

	protected URI getSensor() {
		return sensor;
	}

	protected void setSensor(URI sensor) {
		this.sensor = sensor;
	}

	public String getUrlForDataFile() {
		return urlForDataFile;
	}

	public void setUrlForDataFile(String urlForDataFile) {
		this.urlForDataFile = urlForDataFile;
	}
	
}
