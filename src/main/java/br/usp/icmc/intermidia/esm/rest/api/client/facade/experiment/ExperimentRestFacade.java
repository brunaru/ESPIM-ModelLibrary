package br.usp.icmc.intermidia.esm.rest.api.client.facade.experiment;

import java.net.URI;
import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class ExperimentRestFacade extends GenericRestFacade<Experiment> implements RestFacade<Experiment> {

	private static final String RESOURCE = "experiments";
	/* Relationships */
	private static final String PARTICIPANTS = "participants";
	private static final String RESEARCHERS = "researchers";
	private static final String SAMPLES = "samples";

	private static final String[] linkNames = { PARTICIPANTS, RESEARCHERS, SAMPLES };

	public ExperimentRestFacade() {
		super(RESOURCE, linkNames);
	}

	@Override
	public URI putRelationship(URI objectLocation, URI relationshipLocation) {
		String relationship = relationshipLocation.toString();
		if (relationship.contains(PARTICIPANTS)) {
			return putParticipantRelationship(objectLocation, relationshipLocation);
		} else if (relationship.contains(RESEARCHERS)) {
			return putResearcherRelationship(objectLocation, relationshipLocation);
		} else if (relationship.contains(SAMPLES)) {
			return putSampleRelationship(objectLocation, relationshipLocation);
		} else {
			return null;
		}
	}

	private URI putParticipantRelationship(URI experimentLocation, URI relationshipLocation) {
		Experiment experiment = get(experimentLocation);
		List<URI> participants = getRelationshipLinks(experiment.getLinks().get(PARTICIPANTS), PARTICIPANTS);
		participants.add(relationshipLocation);
		experiment.setParticipants(participants);
		return put(experiment, experimentLocation);
	}

	private URI putSampleRelationship(URI experimentLocation, URI relationshipLocation) {
		Experiment experiment = get(experimentLocation);
		List<URI> samples = getRelationshipLinks(experiment.getLinks().get(SAMPLES), SAMPLES);
		samples.add(relationshipLocation);
		experiment.setSamples(samples);
		return put(experiment, experimentLocation);
	}

	private URI putResearcherRelationship(URI experimentLocation, URI relationshipLocation) {
		Experiment experiment = get(experimentLocation);
		List<URI> researchers = getRelationshipLinks(experiment.getLinks().get(RESEARCHERS), RESEARCHERS);
		researchers.add(relationshipLocation);
		experiment.setResearchers(researchers);
		return put(experiment, experimentLocation);
	}

}
