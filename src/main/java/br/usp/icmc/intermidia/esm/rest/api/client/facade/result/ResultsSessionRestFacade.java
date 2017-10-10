package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class ResultsSessionRestFacade extends GenericRestFacade<ResultsSession> implements RestFacade<ResultsSession> {

	public static final String RESOURCE = "results-session";

	public ResultsSessionRestFacade() {
		super(RESOURCE);
	}

}
