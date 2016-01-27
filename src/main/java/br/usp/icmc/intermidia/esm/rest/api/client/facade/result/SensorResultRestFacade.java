package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import java.net.URI;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class SensorResultRestFacade extends GenericRestFacade<SensorResult> implements RestFacade<SensorResult> {

	private static final String RESOURCE = "sensor-results";
	/* Relationships */
	private static final String SENSOR = "sensor";

	private static final String[] linkNames = { SENSOR };

	public SensorResultRestFacade() {
		super(RESOURCE, linkNames);
	}

	@Override
	public URI putRelationship(URI objectLocation, URI relationshipLocation) {
		SensorResult sensorResult = get(objectLocation);
		sensorResult.setSensor(relationshipLocation);
		return put(sensorResult, objectLocation);
	}

}
