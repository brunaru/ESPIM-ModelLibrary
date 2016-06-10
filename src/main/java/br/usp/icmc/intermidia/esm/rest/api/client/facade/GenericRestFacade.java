package br.usp.icmc.intermidia.esm.rest.api.client.facade;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.GenericTypeResolver;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * @author Brunaru
 *
 * @param <T>
 */
public abstract class GenericRestFacade<T extends AbstractJsonModel> implements RestFacade<T> {

	private final Gson gson;
	private final RestTemplate restTemplate;
	private final Class<T> genericType;
	private final List<String> linkNames;
	private final String resourceName;

	@SuppressWarnings("unchecked")
	public GenericRestFacade(String resourceName, String[] links) {
		this.resourceName = resourceName;
		this.restTemplate = new RestTemplate();
		this.restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		this.gson = new Gson();
		this.linkNames = new ArrayList<String>();
		for (String link : links) {
			this.linkNames.add(link);
		}
		this.linkNames.add("self");
		this.genericType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), GenericRestFacade.class);
	}

	public T get(Long id) {		
		try {
			String s = Constants.REST_API_ADDRESS + resourceName + "/" + id;
			URI location = new URI(s);
			return get(location);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public T get(URI location) {
		try {
			String json = restTemplate.getForObject(location, String.class);
			T object = gson.fromJson(json, genericType);
			setLinksMap(object, json);
			return object;
		} catch (Exception e) {
			// 404
			e.printStackTrace();
			return null;
		}
	}

	public void setLinksMap(T object, String json) {
		try {
			JsonParser jsonParser = new JsonParser();
			JsonElement obj = jsonParser.parse(json);
			Map<String, URI> links = new HashMap<String, URI>();
			for (String linkName : linkNames) {
				JsonElement jElement = obj.getAsJsonObject().get("_links").getAsJsonObject().get(linkName).getAsJsonObject().get("href");
				URI location = gson.fromJson(jElement, URI.class);
				links.put(linkName, location);
				if (linkName.equalsIgnoreCase("self")) {
					object.setSelfLocation(location);
				}
			}
			object.setLinks(links);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<T> getAll() {
		List<T> objects = new ArrayList<T>();
		try {
			String json = restTemplate.getForObject(Constants.REST_API_ADDRESS + resourceName, String.class);
			if (json != null) {
				JsonParser jsonParser = new JsonParser();
				JsonArray jsonArray = jsonParser.parse(json).getAsJsonObject().get("_embedded").getAsJsonObject().getAsJsonArray(resourceName);
				for (JsonElement obj : jsonArray) {
					T object = gson.fromJson(obj, genericType);
					setLinksMap(object, obj.toString());
					objects.add(object);
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public T findByEmail(String email, String searchString, String findStatment) {
		try {
			List<T> objs = findMultipleByEmail(email, searchString, findStatment);
			if (objs == null || objs.isEmpty()) {
				return null;
			}
			return objs.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<T> findMultipleByEmail(String email, String searchString, String findStatment) {
		try {
			String json = restTemplate.getForObject(searchString, String.class);
			List<T> objs = new ArrayList<T>();
			if (json == null) {
				return objs;
			}
			while (json.contains("self")) {
				json = json.substring(json.indexOf("\"self\""));
				String url = json.substring(json.indexOf(Constants.HTTP_STRING), (json.indexOf("}")));
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
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public URI post(T object) {
		try {
			URI location = restTemplate.postForLocation(Constants.REST_API_ADDRESS + resourceName, object);
			return location;
		} catch (Exception e) {
			// if (response.getStatus() != 201)
			e.printStackTrace();
			return null;
		}
	}

	public boolean put(T object, Long id) {		
		try {
			String s = Constants.REST_API_ADDRESS + resourceName + "/" + id;
			URI location = new URI(s);
			restTemplate.put(location, object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean postWithRelationShip(URI parentLocation, String relationshipName, T object) {		
		try {
			String location = parentLocation.toString() + "/" + relationshipName;
			restTemplate.put(location, object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean patch(T object, URI location) {
		try {
			HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
			restTemplate.setRequestFactory(requestFactory);
			HttpEntity<T> entity = new HttpEntity<T>(object);
			restTemplate.exchange(location, HttpMethod.PATCH, entity, String.class);
			//restTemplate.put(location, object);
			return true;
		} catch (Exception e) {
			//if (response.getStatus() != 200)
			e.printStackTrace();
			return false;
		}
	}

	public List<URI> getRelationshipLinks(URI relationshipLocation, String relationshipName) {
		List<URI> relationships = new ArrayList<URI>();
		if (relationshipLocation != null) {
			String json = restTemplate.getForObject(relationshipLocation, String.class);
			JsonParser jsonParser = new JsonParser();
			JsonArray jsonArray = jsonParser.parse(json).getAsJsonObject().get("_embedded").getAsJsonObject().getAsJsonArray(relationshipName);
			if (jsonArray == null) {
				return relationships;
			}
			for (JsonElement obj : jsonArray) {
				JsonElement pLink = obj.getAsJsonObject().get("_links").getAsJsonObject().get("self").getAsJsonObject().get("href");
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
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(URI location) {
		try {
			restTemplate.delete(location);
			return true;
		} catch (Exception e) {
			// if (response.getStatus() != 200 && response.getStatus() != 204)
			return false;
		}
	}

	//protected void error(Response response) {
		//System.out.println("Failed : HTTP error code : " + response.getStatus());
	//}

}
