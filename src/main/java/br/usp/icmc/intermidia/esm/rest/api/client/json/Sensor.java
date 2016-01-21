package br.usp.icmc.intermidia.esm.rest.api.client.json;

public class Sensor {
	
	/** Used for capturing sensors during an interval. */
	public static final int SENSOR_TYPE_INTERVAL = 0;
	
	/** Used for capturing sensors during a sample. */
	public static final int SENSOR_TYPE_TASK = 1;
	
	/** Activity sensor. */
	public static final int SENSOR_ACTIVITY = 1;
	
	/** Interval or sample. */
	private int sensorType;
	
	/** ACITIVTY, LIGHT, AUDIO, ETC. */
	private int sensor;

	public int getSensor() {
		return sensor;
	}

	public void setSensor(int sensor) {
		this.sensor = sensor;
	}

	public int getSensorType() {
		return sensorType;
	}

	public void setSensorType(int sensorType) {
		this.sensorType = sensorType;
	}

}
