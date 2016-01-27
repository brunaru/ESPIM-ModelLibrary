package br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class QuestionInterventionRestFacade extends InterventionRestFacade implements RestFacade<Intervention> {

	private static final String RESOURCE = "question-interventions";

	public QuestionInterventionRestFacade() {
		super(RESOURCE);
	}

}
