package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.model.result.Result;

public abstract class ResultRestFacade<T extends Result> extends GenericRestFacade<T> implements RestFacade<T> {

	/* Relationships */
	public static final String PARTICIPANT = "participant";
	
	public static final String OBSERVER = "observer";
	
	public ResultRestFacade(String resource) {
		super(resource);
	}

}
