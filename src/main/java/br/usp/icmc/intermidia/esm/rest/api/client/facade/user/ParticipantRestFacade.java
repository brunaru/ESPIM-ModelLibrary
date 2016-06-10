package br.usp.icmc.intermidia.esm.rest.api.client.facade.user;

import java.net.URI;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.Constants;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class ParticipantRestFacade extends GenericRestFacade<Person> implements RestFacade<Person> {

	private static final String RESOURCE = "participants";

	private static final String[] linkNames = {};

	public ParticipantRestFacade() {
		super(RESOURCE, linkNames);
	}
	
	public Person findByEmail(String email) {
		String s = Constants.REST_API_ADDRESS + RESOURCE + "/" + "search/findByEmail?email=" + email;
		return findByEmail(email, s, "findByEmail");
	}

	@Override
	public boolean putRelationship(URI objectLocation, URI relationshipLocation) {
		return false;
	}

}
