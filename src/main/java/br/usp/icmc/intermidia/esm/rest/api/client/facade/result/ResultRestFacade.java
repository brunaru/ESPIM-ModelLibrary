package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import java.net.URI;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public abstract class ResultRestFacade<T extends Result> extends GenericRestFacade<T> implements RestFacade<T> {

	/* Relationships */
	public static final String PARTICIPANT = "participant";
	
	public static final String OBSERVER = "observer";
	
	public ResultRestFacade(String resource, String[] links) {
		super(resource, links);
	}
	
	protected boolean putParticipantRelationship(URI objectLocation, URI relationshipLocation) {
		T result = get(objectLocation);
		result.setParticipant(relationshipLocation);
		return patch(result, objectLocation);
	}

}
