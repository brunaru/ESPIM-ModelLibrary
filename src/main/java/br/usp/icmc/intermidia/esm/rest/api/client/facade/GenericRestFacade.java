package br.usp.icmc.intermidia.esm.rest.api.client.facade;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.model.AbstractJsonModel;
import org.springframework.core.GenericTypeResolver;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

/**
 * @author Brunaru
 *
 * @param <T>
 */
public abstract class GenericRestFacade<T extends AbstractJsonModel> implements RestFacade<T> {

	private final ObjectMapper mapper;
	private final RestTemplate restTemplate;
	private final Class<T> genericType;
	protected final String resourceName;
	private HttpHeaders headers = new HttpHeaders();

	@SuppressWarnings("unchecked")
	public GenericRestFacade(String resourceName) {
		this.resourceName = resourceName;
		this.restTemplate = new RestTemplate();
		this.restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		this.restTemplate.getMessageConverters().add(1, new MappingJackson2HttpMessageConverter());
		mapper = new ObjectMapper();
		this.genericType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), GenericRestFacade.class);
		headers.setContentType(MediaType.APPLICATION_JSON);
	}
	
	public GenericRestFacade(String resourceName, String token) {
		this(resourceName);
		headers = createHeaders(token);
		headers.setContentType(MediaType.APPLICATION_JSON);
	}
	
	HttpHeaders createHeaders(String token) {
		return new HttpHeaders() {
			private static final long serialVersionUID = 488918398000090553L;

			{
				String authHeader = "Basic " + token;
				set("Authorization", authHeader);
			}
		};
	}

	public T get(Long id) {
		try {
			String s = ApiAddress.getRestApiAddress() + resourceName + "/" + id + "/";
			URI location = new URI(s);
			return get(location);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public T get(Long id, boolean verbose) {
		if (!verbose) {
			return get(id);
		}
		try {
			String s = ApiAddress.getRestApiAddress() + resourceName + "/" + id + "/?verbose=true";
			URI location = new URI(s);
			return get(location);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public T get(URI location) {
		try {
			HttpEntity<String> entity = new HttpEntity<>(headers);
			ResponseEntity<String> response = restTemplate.exchange(location, HttpMethod.GET, entity, String.class);
			String json = response.getBody();
			//String json = restTemplate.getForObject(location, String.class);
			T object = mapper.readValue(json, genericType);
			return object;
		} catch (Exception e) {
			// 404
			e.printStackTrace();
			return null;
		}
	}

	public List<T> getAll() {
		List<T> objects = new ArrayList<T>();
		try {
			HttpEntity<String> entity = new HttpEntity<>(headers);
			ResponseEntity<String> response = restTemplate.exchange(ApiAddress.getRestApiAddress() + resourceName + "/?verbose=true", HttpMethod.GET, entity, String.class);
			String json = response.getBody();
			//String json = restTemplate.getForObject(ApiAddress.getRestApiAddress() + resourceName + "/?verbose=true", String.class);
			if (json != null) {
				objects = mapper.readValue(json, TypeFactory.defaultInstance().constructCollectionType(List.class, genericType));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public T findByValue(String value, String findString, String resource) {
		try {
			List<T> objs = findMultipleByValue(value, findString, resource);
			if (objs == null || objs.isEmpty()) {
				return null;
			}
			return objs.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<T> findMultipleByValue(String value, String findString, String resource) {
		String searchString = ApiAddress.getRestApiAddress() + resource + "/" + findString + value;
		List<T> objects = new ArrayList<T>();
		String json = null;
		try {
			HttpEntity<String> entity = new HttpEntity<>(headers);
			ResponseEntity<String> response = restTemplate.exchange(searchString, HttpMethod.GET, entity, String.class);
			json = response.getBody();
			//json = restTemplate.getForObject(searchString, String.class);
		} catch (Exception e) {
			e.printStackTrace();
			return objects;
		}
		try {
			T object = mapper.readValue(json, genericType);
			objects.add(object);
		} catch (Exception e1) {
			try {
				objects = mapper.readValue(json, TypeFactory.defaultInstance().constructCollectionType(List.class, genericType));
			} catch (Exception e2) {
				e1.printStackTrace();
				e2.printStackTrace();
			}
		}
		return objects;
	}

	private String post(T object, String url) {
		try {
			String json = mapper.writeValueAsString(object);
			json = json.replaceAll("\"id\":0,", "");
			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			String answer = restTemplate.postForObject(url, entity, String.class);
			return answer;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String post(T object, boolean verbose) {
		if (!verbose) {
			return post(object, ApiAddress.getRestApiAddress() + resourceName + "/");
		} else {
			return post(object, ApiAddress.getRestApiAddress() + resourceName + "/?verbose=true");
		}
	}

	public boolean put(T object, String url) {
		try {
			String json = mapper.writeValueAsString(object);
			HttpEntity<String> entity = new HttpEntity<String>(json, headers);			
			restTemplate.put(url, entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean put(T object, Long id, boolean verbose) {
		if (!verbose) {
			return put(object, ApiAddress.getRestApiAddress() + resourceName + "/" + id + "/");
		}
		try {
			return put(object, ApiAddress.getRestApiAddress() + resourceName + "/" + id + "/?verbose=true");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean patch(T object, URI location) {
		try {
			HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
			restTemplate.setRequestFactory(requestFactory);
			MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
			headers.setContentType(mediaType);
			String json = mapper.writeValueAsString(object);
			HttpEntity<String> entity = new HttpEntity<String>(json, headers);
			restTemplate.exchange(location, HttpMethod.PATCH, entity, String.class);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String getAsJson(T object) {
		String json = null;
		try {
			json = mapper.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	public T getAsObject(String json) {
		T object = null;
		try {
			object = mapper.readValue(json, genericType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	public boolean delete(Long id) {
		String s = ApiAddress.getRestApiAddress() + resourceName + "/" + id + "/";
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
			e.printStackTrace();
			return false;
		}
	}
}
