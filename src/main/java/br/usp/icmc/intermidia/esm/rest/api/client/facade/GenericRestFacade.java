package br.usp.icmc.intermidia.esm.rest.api.client.facade;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.experiment.Experiment;

public class GenericRestFacade {

	private Client client;
	private Gson gson;

	public GenericRestFacade() {
		client = Client.create();
		gson = new Gson();
	}

	public Object get(Long id, String resourceName) {
		String s = Constants.REST_API_ADDRESS + resourceName + id;
		try {
			URI location = new URI(s);
			return get(location);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String get(URI location) {
		WebResource resource = client.resource(location);
		ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
		String json = response.getEntity(String.class);
		if (response.getStatus() != 200) {
			error(response);
			return null;
		}
		return json;
	}

	public String getAll(String resourceName) {
		WebResource resource = client.resource(Constants.REST_API_ADDRESS + resourceName);
		ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
		String json = response.getEntity(String.class);
		return json;
	}

	public URI post(Object object, String resourceName) {
		String json = gson.toJson(object);
		WebResource resource = client.resource(Constants.REST_API_ADDRESS + resourceName);
		ClientResponse response = resource.type("application/json").post(ClientResponse.class, json);
		URI location = response.getLocation();
		if (response.getStatus() != 201) {
			error(response);
			return null;
		}
		return location;
	}

	public URI put(Object object, Long id, String resourceName) {
		String s = Constants.REST_API_ADDRESS + resourceName + id;
		try {
			URI location = new URI(s);
			return put(object, location);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	public URI put(Object object, URI location) {
		String json = gson.toJson(object);
		WebResource resource = client.resource(location);
		ClientResponse response = resource.type("application/json").put(ClientResponse.class, json);
		location = response.getLocation();
		if (response.getStatus() != 200) {
			error(response);
			return null;
		}
		return location;
	}

	protected List<URI> getRelationshipLinks(URI relationshipLocation, String relationshipName) {
		List<URI> relationships = new ArrayList<URI>();
		WebResource resource = client.resource(relationshipLocation);
		ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
		String json = response.getEntity(String.class);
		JsonParser jsonParser = new JsonParser();
		JsonArray jsonArray = jsonParser.parse(json).getAsJsonObject().get("_embedded").getAsJsonObject()
				.getAsJsonArray(relationshipName);
		for (JsonElement obj : jsonArray) {
			JsonElement pLink = obj.getAsJsonObject().get("_links").getAsJsonObject().get("self").getAsJsonObject()
					.get("href");
			URI pURI = gson.fromJson(pLink, URI.class);
			relationships.add(pURI);
		}
		return relationships;
	}

	public boolean deleteRelationship(URI objectLocation, URI relationshipLocation) {
		try {
			URI relative = new URI(Constants.REST_API_ADDRESS);
			URI relationship = relative.relativize(relationshipLocation);
			String location = objectLocation + "/" + relationship;
			return delete(new URI(location));
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Long id, String resourceName) {
		String s = Constants.REST_API_ADDRESS + resourceName + id;
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

	protected void error(ClientResponse response) {
		System.out.println("ExperimentRestFacade Failed : HTTP error code : " + response.getStatus());
	}

	private void setLinksMap(Experiment experiment, JsonElement obj, String linkName) {

	}

}
