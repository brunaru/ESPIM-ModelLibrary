package br.usp.icmc.intermidia.esm.rest.api.client.model.sensor;

import br.usp.icmc.intermidia.esm.rest.api.client.model.AbstractJsonModel;

public class Sensor extends AbstractJsonModel {
	
	private static final long serialVersionUID = -486477498654571055L;

	/** Used for capturing sensors during an interval. */
	public static final int SENSOR_TYPE_INTERVAL = 0;
	
	/** Used for capturing sensors during a event. */
	public static final int SENSOR_TYPE_TASK = 1;
	
	/** Activity sensor. */
	public static final String SENSOR_ACTIVITY = "activity";
	/** Accelerometer sensor. */
	public static final String SENSOR_ACCELEROMETER = "accelerometer";
	/** Video sensor. */
	public static final String SENSOR_CAMERA = "camera";
	/** Light sensor. */
	public static final String SENSOR_LIGHT = "light";
	/** Audio sensor. */
	public static final String SENSOR_MICROPHONE = "microphone";
	
	/** Interval or whole event. */
	private int sensorType;
	
	/** ACITIVTY, LIGHT, AUDIO, ETC. */
	private String sensor;

	public String getSensor() {
		return sensor;
	}

	public void setSensor(String sensor) {
		this.sensor = sensor;
	}

	public int getSensorType() {
		return sensorType;
	}

	public void setSensorType(int sensorType) {
		this.sensorType = sensorType;
	}

}
