package br.usp.icmc.intermidia.esm.rest.api.client.facade;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.GenericTypeResolver;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public abstract class GenericRestFacade<T extends AbstractJsonModel> implements RestFacade<T> {

	private final Client client;
	private final Gson gson;
	private final Class<T> genericType;
	private final List<String> linkNames;
	private final String resourceName;

	@SuppressWarnings("unchecked")
	public GenericRestFacade(String resourceName, String[] links) {
		this.resourceName = resourceName;
		client = Client.create();
		gson = new Gson();
		this.linkNames = new ArrayList<String>();
		for (String link : links) {
			this.linkNames.add(link);
		}
		this.linkNames.add("self");
		this.genericType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), GenericRestFacade.class);
	}

	public T get(Long id) {
		String s = Constants.REST_API_ADDRESS + resourceName + "/" + id;
		try {
			URI location = new URI(s);
			return get(location);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	public T get(URI location) {
		WebResource resource = client.resource(location);
		ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
		String json = response.getEntity(String.class);
		T object = gson.fromJson(json, genericType);
		setLinksMap(object, json);
		if (response.getStatus() != 200) {
			error(response);
			return null;
		}
		return object;
	}

	public void setLinksMap(T object, String json) {
		JsonParser jsonParser = new JsonParser();
		JsonElement obj = jsonParser.parse(json);
		Map<String, URI> links = new HashMap<String, URI>();
		for (String linkName : linkNames) {
			JsonElement jElement = obj.getAsJsonObject().get("_links").getAsJsonObject().get(linkName).getAsJsonObject()
					.get("href");
			URI location = gson.fromJson(jElement, URI.class);
			links.put(linkName, location);
			if (linkName.equalsIgnoreCase("self")) {
				object.setSelfLocation(location);
			}
		}
		object.setLinks(links);
	}

	public List<T> getAll() {
		WebResource resource = client.resource(Constants.REST_API_ADDRESS + resourceName);
		ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
		String json = response.getEntity(String.class);
		JsonParser jsonParser = new JsonParser();
		JsonArray jsonArray = jsonParser.parse(json).getAsJsonObject().get("_embedded").getAsJsonObject()
				.getAsJsonArray(resourceName);
		List<T> objects = new ArrayList<T>();
		for (JsonElement obj : jsonArray) {
			T object = gson.fromJson(obj, genericType);
			setLinksMap(object, obj.toString());
			objects.add(object);
		}
		if (response.getStatus() != 200) {
			error(response);
			return null;
		}
		return objects;
	}
	
	public T findByEmail(String email, String searchString, String findStatment) {
		List<T> objs = findMultipleByEmail(email, searchString, findStatment);
		if (objs == null || objs.isEmpty()) {
			return null;
		}
		return objs.get(0);
	}

	public List<T> findMultipleByEmail(String email, String searchString, String findStatment) {
		try {
			URI searchURI = new URI(searchString);
			Client client = Client.create();
			WebResource resource = client.resource(searchURI);
			ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
			String json = response.getEntity(String.class);

			List<T> objs = new ArrayList<T>();
			while (json.contains("self")) {
				json = json.substring(json.indexOf("\"self\""));
				String url = json.substring(json.indexOf("https"), (json.indexOf("}")));
				url = url.substring(0, url.lastIndexOf("\""));
				if (!url.contains(findStatment)) {
					URI location = new URI(url);
					T obj = get(location);
					if (obj != null) {
						objs.add(obj);
					}
				}
				json = json.substring(5);
			}
			return objs;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	public URI post(T object) {
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

	public URI put(T object, Long id) {
		String s = Constants.REST_API_ADDRESS + resourceName + "/" + id;
		try {
			URI location = new URI(s);
			return put(object, location);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	public URI put(T object, URI location) {
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

	public List<URI> getRelationshipLinks(URI relationshipLocation, String relationshipName) {
		List<URI> relationships = new ArrayList<URI>();
		if (relationshipLocation != null) {
			WebResource resource = client.resource(relationshipLocation);
			ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
			String json = response.getEntity(String.class);
			JsonParser jsonParser = new JsonParser();
			JsonArray jsonArray = jsonParser.parse(json).getAsJsonObject().get("_embedded").getAsJsonObject()
					.getAsJsonArray(relationshipName);
			if (jsonArray == null) {
				return relationships;
			}
			for (JsonElement obj : jsonArray) {
				JsonElement pLink = obj.getAsJsonObject().get("_links").getAsJsonObject().get("self").getAsJsonObject()
						.get("href");
				URI pURI = gson.fromJson(pLink, URI.class);
				relationships.add(pURI);
			}
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

	public boolean delete(Long id) {
		String s = Constants.REST_API_ADDRESS + resourceName + "/" + id;
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
		System.out.println("Failed : HTTP error code : " + response.getStatus());
	}

}
