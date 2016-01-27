package br.usp.icmc.intermidia.esm.rest.api.client.facade.sensor;

import java.net.URI;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class SensorRestFacade extends GenericRestFacade<Sensor> implements RestFacade<Sensor> {

	private static final String RESOURCE = "sensors";

	private static final String[] linkNames = {};

	public SensorRestFacade() {
		super(RESOURCE, linkNames);
	}

	@Override
	public URI putRelationship(URI objectLocation, URI relationshipLocation) {
		return null;
	}

}