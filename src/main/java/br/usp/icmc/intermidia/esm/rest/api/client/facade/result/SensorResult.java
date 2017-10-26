package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

public class SensorResult extends Result {

	private static final long serialVersionUID = 4967467744192534699L;

	private long sensor;
	
	private String urlForDataFile;
	
	public SensorResult() {
		this.setType("sensor");
	}

	public String getUrlForDataFile() {
		return urlForDataFile;
	}

	public void setUrlForDataFile(String urlForDataFile) {
		this.urlForDataFile = urlForDataFile;
	}

	public long getSensor() {
		return sensor;
	}

	public void setSensor(long sensor) {
		this.sensor = sensor;
	}
	
}
