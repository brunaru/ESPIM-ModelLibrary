package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import java.net.URI;
import java.sql.Blob;

public class SensorResult extends Result {

	private URI sensor;
	
	private Blob resultData;

	public URI getSensor() {
		return sensor;
	}

	public void setSensor(URI sensor) {
		this.sensor = sensor;
	}

	public Blob getResultData() {
		return resultData;
	}

	public void setResultData(Blob resultData) {
		this.resultData = resultData;
	}
	
}
