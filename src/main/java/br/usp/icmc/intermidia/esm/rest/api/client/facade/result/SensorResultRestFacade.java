package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import java.net.URI;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class SensorResultRestFacade extends ResultRestFacade<SensorResult> implements RestFacade<SensorResult> {

	public static final String RESOURCE = "sensor-results";
	/* Relationships */
	public static final String SENSOR = "sensor";

	private static final String[] linkNames = { SENSOR, PARTICIPANT };

	public SensorResultRestFacade() {
		super(RESOURCE, linkNames);
	}

	@Override
	public boolean putRelationship(URI objectLocation, URI relationshipLocation) {
		String relationship = relationshipLocation.toString();
		if (relationship.contains(PARTICIPANT)) {
			return putParticipantRelationship(objectLocation, relationshipLocation);
		} else if (relationship.contains(SENSOR)) {
			SensorResult sensorResult = get(objectLocation);
			sensorResult.setSensor(relationshipLocation);
			return patch(sensorResult, objectLocation);
		} else {
			return false;
		}
	}

}
