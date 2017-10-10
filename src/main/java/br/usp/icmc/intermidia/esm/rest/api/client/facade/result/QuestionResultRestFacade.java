package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class QuestionResultRestFacade extends ResultRestFacade<QuestionResult> implements RestFacade<QuestionResult> {

	public static final String RESOURCE = "question-results";
	/* Relationships */
	public static final String QUESTION = "question";

	public QuestionResultRestFacade() {
		super(RESOURCE);
	}

}
