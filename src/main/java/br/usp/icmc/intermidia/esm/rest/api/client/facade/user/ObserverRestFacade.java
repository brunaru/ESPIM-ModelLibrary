package br.usp.icmc.intermidia.esm.rest.api.client.facade.user;

import java.net.URI;
import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class ObserverRestFacade extends GenericRestFacade<Observer> implements RestFacade<Observer> {

	private static final String RESOURCE = "observers";
	/* Relationships */
	private static final String CONTACTS = "contacts";

	private static final String[] linkNames = { CONTACTS };

	public ObserverRestFacade() {
		super(RESOURCE, linkNames);
	}

	@Override
	public URI putRelationship(URI objectLocation, URI relationshipLocation) {
		String relationship = relationshipLocation.toString();
		if (relationship.contains(CONTACTS)) {
			Observer observer = get(objectLocation);
			List<URI> contacts = getRelationshipLinks(observer.getLinks().get(CONTACTS), CONTACTS);
			contacts.add(relationshipLocation);
			observer.setContacts(contacts);
			return put(observer, objectLocation);
		} else {
			return null;
		}
	}

}