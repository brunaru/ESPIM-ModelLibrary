package br.usp.icmc.intermidia.esm.rest.api.client.facade.user;

import java.net.URI;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class ParticipantRestFacade extends GenericRestFacade<Person> implements RestFacade<Person> {

	private static final String RESOURCE = "participants";

	private static final String[] linkNames = {};

	public ParticipantRestFacade() {
		super(RESOURCE, linkNames);
	}

	@Override
	public URI putRelationship(URI objectLocation, URI relationshipLocation) {
		return null;
	}

}
