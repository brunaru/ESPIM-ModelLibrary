package br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.model.intervention.QuestionIntervention;

public class QuestionInterventionRestFacade extends InterventionRestFacade<QuestionIntervention> implements RestFacade<QuestionIntervention> {

	public static final String RESOURCE = "question-interventions";

	public QuestionInterventionRestFacade() {
		super(RESOURCE);
	}

}
