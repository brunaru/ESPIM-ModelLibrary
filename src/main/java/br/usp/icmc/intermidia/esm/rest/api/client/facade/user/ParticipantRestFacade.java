package br.usp.icmc.intermidia.esm.rest.api.client.facade.user;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.Constants;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class ParticipantRestFacade extends GenericRestFacade<Person> implements RestFacade<Person> {

	public static final String RESOURCE = "participants";

	public ParticipantRestFacade() {
		super(RESOURCE);
	}
	
	public Person findByEmail(String email) {
		String s = Constants.REST_API_ADDRESS + RESOURCE + "/" + "search/findByEmail?email=" + email;
		return findByEmail(email, s, "findByEmail", RESOURCE);
	}

}
