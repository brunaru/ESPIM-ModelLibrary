package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.model.result.EmptyResult;

public class EmptyResultRestFacade extends ResultRestFacade<EmptyResult> implements RestFacade<EmptyResult> {

	public static final String RESOURCE = "empty-results";
	/* Relationships */
	public static final String QUESTION = "empty";

	public EmptyResultRestFacade() {
		super(RESOURCE);
	}

}
