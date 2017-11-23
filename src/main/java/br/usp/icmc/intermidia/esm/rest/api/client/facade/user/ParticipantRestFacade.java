package br.usp.icmc.intermidia.esm.rest.api.client.facade.user;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.model.user.Person;

public class ParticipantRestFacade extends GenericRestFacade<Person> implements RestFacade<Person> {

	public static final String RESOURCE = "participants";

	public ParticipantRestFacade() {
		super(RESOURCE);
	}
	
	public Person findByEmail(String email) {
		return findByValue(email, "search/findByEmail?email=", RESOURCE);
	}

}
