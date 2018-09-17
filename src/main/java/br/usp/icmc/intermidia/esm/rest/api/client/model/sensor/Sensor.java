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
	
	/** Collector Device: smartphone. */
	public static final String COLLECTOR_SMARTPHONE = "smartphone";
	
	/** Collector Device: smartwatch. */
	public static final String COLLECTOR_SMARTWATCH = "smartwatch";
	
	/** Interval or whole event. */
	private int sensorType;
	
	/** ACITIVTY, LIGHT, AUDIO, ETC. */
	private String sensor;
	
	/** Device. Smartphone, smartwatch, etc. */
	private String collector;

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

	public String getCollector() {
		return collector;
	}

	public void setCollector(String collector) {
		this.collector = collector;
	}

}
