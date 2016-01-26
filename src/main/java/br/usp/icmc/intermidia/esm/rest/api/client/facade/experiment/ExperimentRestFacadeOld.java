package br.usp.icmc.intermidia.esm.rest.api.client.facade.experiment;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.Constants;

public class ExperimentRestFacadeOld {

	private static String RESOURCE = "experiments/";
	/* Relationships */
	private static String PARTICIPANTS = "participants";
	private static String RESEARCHERS = "researchers";
	private static String SAMPLES = "samples";

	private Client client;
	private Gson gson;

	public ExperimentRestFacadeOld() {
		client = Client.create();
		gson = new Gson();
	}

	public Experiment get(Long id) {
		String s = Constants.REST_API_ADDRESS + RESOURCE + id;
		try {
			URI location = new URI(s);
			return get(location);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Experiment get(URI location) {
		WebResource resource = client.resource(location);
		ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
		String json = response.getEntity(String.class);
		Experiment experiment = gson.fromJson(json, Experiment.class);		
		setExperimentLinksMap(experiment, json);		
		if (response.getStatus() != 200) {
			error(response);
			return null;
		}
		return experiment;
	}
	
	private void setExperimentLinksMap(Experiment experiment, String json) {
		JsonParser jsonParser = new JsonParser();
		JsonElement obj = jsonParser.parse(json);
		setExperimentLinksMap(experiment, obj);
	}
	
	private void setExperimentLinksMap(Experiment experiment, JsonElement obj) {
		JsonElement pObj = obj.getAsJsonObject().get("_links").getAsJsonObject().get(PARTICIPANTS).getAsJsonObject().get("href");
        JsonElement rObj = obj.getAsJsonObject().get("_links").getAsJsonObject().get(RESEARCHERS).getAsJsonObject().get("href");
        JsonElement sObj = obj.getAsJsonObject().get("_links").getAsJsonObject().get(SAMPLES).getAsJsonObject().get("href");        
        URI participantsLocation = gson.fromJson(pObj, URI.class);
        URI researchersLocation = gson.fromJson(rObj, URI.class);
        URI samplesLocation = gson.fromJson(sObj, URI.class);
        Map<String, URI> links = new HashMap<String, URI>();
        links.put(PARTICIPANTS, participantsLocation);
        links.put(RESEARCHERS, researchersLocation);
        links.put(SAMPLES, samplesLocation);
        experiment.setLinks(links);
	}

	public List<Experiment> getAll() {
		WebResource resource = client.resource(Constants.REST_API_ADDRESS + RESOURCE);
		ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
		String json = response.getEntity(String.class);
		JsonParser jsonParser = new JsonParser();
		JsonArray jsonArray = jsonParser.parse(json).getAsJsonObject().get("_embedded").getAsJsonObject()
				.getAsJsonArray("experiments");
		List<Experiment> experiments = new ArrayList<Experiment>();
		for(JsonElement obj : jsonArray) {
	        Experiment experiment = gson.fromJson(obj, Experiment.class);
	        setExperimentLinksMap(experiment, obj);
	        experiments.add(experiment);
		}
		if (response.getStatus() != 200) {
			error(response);
			return null;
		}
		return experiments;
	}

	public URI post(Experiment experiment) {
		String json = gson.toJson(experiment);
		WebResource resource = client.resource(Constants.REST_API_ADDRESS + RESOURCE);
		ClientResponse response = resource.type("application/json").post(ClientResponse.class, json);
		URI location = response.getLocation();
		if (response.getStatus() != 201) {
			error(response);
			return null;
		}
		return location;
	}

	public URI put(Experiment experiment, Long id) {
		String s = Constants.REST_API_ADDRESS + RESOURCE + id;
		try {
			URI location = new URI(s);
			return put(experiment, location);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	public URI put(Experiment experiment, URI location) {
		String json = gson.toJson(experiment);
		WebResource resource = client.resource(location);
		ClientResponse response = resource.type("application/json").put(ClientResponse.class, json);
		
		location = response.getLocation();
		if (response.getStatus() != 200) {
			error(response);
			return null;
		}
		return location;
	}
	
	public URI putParticipantRelationship(URI experimentLocation, URI relationshipLocation) {
		Experiment experiment = get(experimentLocation);
		List<URI> participants = getRelationshipLinks(experiment.getLinks().get(PARTICIPANTS), PARTICIPANTS);
		participants.add(relationshipLocation);
		experiment.setParticipants(participants);
		return put(experiment, experimentLocation);
	}
	
	public URI putSampleRelationship(URI experimentLocation, URI relationshipLocation) {
		Experiment experiment = get(experimentLocation);
		List<URI> samples = getRelationshipLinks(experiment.getLinks().get(SAMPLES), SAMPLES);
		samples.add(relationshipLocation);
		experiment.setSamples(samples);
		return put(experiment, experimentLocation);
	}
	
	public URI putResearcherRelationship(URI experimentLocation, URI relationshipLocation) {
		Experiment experiment = get(experimentLocation);
		List<URI> researchers = getRelationshipLinks(experiment.getLinks().get(RESEARCHERS), RESEARCHERS);
		researchers.add(relationshipLocation);
		experiment.setResearchers(researchers);
		return put(experiment, experimentLocation);
	}
	
	private List<URI> getRelationshipLinks(URI participantsLocation, String relationshipName) {
		List<URI> participants = new ArrayList<URI>();
		WebResource resource = client.resource(participantsLocation);
		ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
		String json = response.getEntity(String.class);
		JsonParser jsonParser = new JsonParser();
		JsonArray jsonArray = jsonParser.parse(json).getAsJsonObject().get("_embedded").getAsJsonObject()
				.getAsJsonArray(relationshipName);
		for (JsonElement obj : jsonArray) {
			JsonElement pLink = obj.getAsJsonObject().get("_links").getAsJsonObject().get("self").getAsJsonObject()
					.get("href");
			URI pURI = gson.fromJson(pLink, URI.class);
			participants.add(pURI);
		}
		return participants;
	}
	
	public boolean deleteRelationship(URI experimentLocation, URI relationshipLocation) {
		try {
			URI relative = new URI(Constants.REST_API_ADDRESS);
			URI relationship = relative.relativize(relationshipLocation);
			String location = experimentLocation + "/" + relationship;
			return delete(new URI(location));
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Long id) {
		String s = Constants.REST_API_ADDRESS + RESOURCE + id;
		try {
			URI location = new URI(s);
			return delete(location);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(URI location) {
		WebResource resource = client.resource(location);
		ClientResponse response = resource.type("application/json").delete(ClientResponse.class);
		if (response.getStatus() != 200 && response.getStatus() != 204) {
			error(response);
			return false;
		}
		return true;
	}

	private void error(ClientResponse response) {
		System.out.println("ExperimentRestFacade Failed : HTTP error code : " + response.getStatus());
	}

}
