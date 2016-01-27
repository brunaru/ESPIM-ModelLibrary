package br.usp.icmc.intermidia.esm.rest.api.client.facade.user;

import java.net.URI;
import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class ResearcherRestFacade extends GenericRestFacade<Researcher> implements RestFacade<Researcher> {

	private static final String RESOURCE = "researchers";
	/* Relationships */
	private static final String CONTACTS = "contacts";

	private static final String[] linkNames = { CONTACTS };

	public ResearcherRestFacade() {
		super(RESOURCE, linkNames);
	}

	@Override
	public URI putRelationship(URI objectLocation, URI relationshipLocation) {
		Researcher researcher = get(objectLocation);
		List<URI> contacts = getRelationshipLinks(researcher.getLinks().get(CONTACTS), CONTACTS);
		contacts.add(relationshipLocation);
		researcher.setContacts(contacts);
		return put(researcher, objectLocation);
	}

}
