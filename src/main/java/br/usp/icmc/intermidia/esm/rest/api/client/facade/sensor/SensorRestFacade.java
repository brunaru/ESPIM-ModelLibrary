package br.usp.icmc.intermidia.esm.rest.api.client.facade.sensor;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class SensorRestFacade extends GenericRestFacade<Sensor> implements RestFacade<Sensor> {

	public static final String RESOURCE = "sensors";

	public SensorRestFacade() {
		super(RESOURCE);
	}

}
