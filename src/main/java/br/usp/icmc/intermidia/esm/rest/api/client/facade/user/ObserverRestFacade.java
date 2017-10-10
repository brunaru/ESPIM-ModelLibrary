package br.usp.icmc.intermidia.esm.rest.api.client.facade.user;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.Constants;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class ObserverRestFacade extends GenericRestFacade<Observer> implements RestFacade<Observer> {

	public static final String RESOURCE = "observers";
	/* Relationships */
	public static final String CONTACTS = "contacts";

	public ObserverRestFacade() {
		super(RESOURCE);
	}

	public Observer findByEmail(String email) {
		String s = Constants.REST_API_ADDRESS + RESOURCE + "/" + "search/findByEmail?email=" + email;
		return findByEmail(email, s, "findByEmail", RESOURCE);
	}

}
