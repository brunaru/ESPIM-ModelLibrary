package br.usp.icmc.intermidia.esm.rest.api.client.facade.user;

import java.net.URI;
import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.Constants;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class ObserverRestFacade extends GenericRestFacade<Observer> implements RestFacade<Observer> {

	public static final String RESOURCE = "observers";
	/* Relationships */
	public static final String CONTACTS = "contacts";

	private static final String[] linkNames = { CONTACTS };

	public ObserverRestFacade() {
		super(RESOURCE, linkNames);
	}

	public Observer findByEmail(String email) {
		String s = Constants.REST_API_ADDRESS + RESOURCE + "/" + "search/findByEmail?email=" + email;
		return findByEmail(email, s, "findByEmail");
	}

	@Override
	public boolean putRelationship(URI objectLocation, URI relationshipLocation) {
		String relationship = relationshipLocation.toString();
		if (relationship.contains(CONTACTS)) {
			Observer observer = get(objectLocation);
			List<URI> contacts = getRelationshipLinks(observer.getLinks().get(CONTACTS), CONTACTS);
			contacts.add(relationshipLocation);
			observer.setContacts(contacts);
			return patch(observer, objectLocation);
		} else {
			return false;
		}
	}

}
