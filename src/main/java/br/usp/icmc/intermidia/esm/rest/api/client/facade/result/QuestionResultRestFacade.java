package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import java.net.URI;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class QuestionResultRestFacade extends ResultRestFacade<QuestionResult> implements RestFacade<QuestionResult> {

	public static final String RESOURCE = "question-results";
	/* Relationships */
	public static final String QUESTION = "question";

	private static final String[] linkNames = { QUESTION, PARTICIPANT };

	public QuestionResultRestFacade() {
		super(RESOURCE, linkNames);
	}

	@Override
	public boolean putRelationship(URI objectLocation, URI relationshipLocation) {
		String relationship = relationshipLocation.toString();
		if (relationship.contains(PARTICIPANT)) {
			return putParticipantRelationship(objectLocation, relationshipLocation);
		} else if (relationship.contains(QUESTION)) {
			QuestionResult questionResult = get(objectLocation);
			questionResult.setQuestion(relationshipLocation);
			return patch(questionResult, objectLocation);
		} else {
			return false;
		}		
	}

}
