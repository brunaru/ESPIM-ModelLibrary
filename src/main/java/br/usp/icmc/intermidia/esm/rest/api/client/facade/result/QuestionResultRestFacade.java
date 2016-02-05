package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import java.net.URI;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class QuestionResultRestFacade extends ResultRestFacade<QuestionResult> implements RestFacade<QuestionResult> {

	private static final String RESOURCE = "question-results";
	/* Relationships */
	private static final String QUESTION = "question";

	private static final String[] linkNames = { QUESTION, PARTICIPANT };

	public QuestionResultRestFacade() {
		super(RESOURCE, linkNames);
	}

	@Override
	public URI putRelationship(URI objectLocation, URI relationshipLocation) {
		String relationship = relationshipLocation.toString();
		if (relationship.contains(PARTICIPANT)) {
			return putParticipantRelationship(objectLocation, relationshipLocation);
		} else if (relationship.contains(QUESTION)) {
			QuestionResult questionResult = get(objectLocation);
			questionResult.setQuestion(relationshipLocation);
			return put(questionResult, objectLocation);
		} else {
			return null;
		}		
	}

}
