package br.usp.icmc.intermidia.esm.rest.api.client.facade;

import java.net.URI;
import java.util.List;

public interface RestFacade<T> {
	
	public T get(Long id);

	public T get(URI location);
	
	public void setLinksMap(T object, String json);

	public List<T> getAll();

	public URI post(T object);

	public URI put(T object, Long id);

	public URI put(T object, URI location);
	
	public URI putRelationship(URI objectLocation, URI relationshipLocation);
	
	public List<URI> getRelationshipLinks(URI objectLocation, String relationshipName);
	
	public boolean deleteRelationship(URI objectLocation, URI relationshipLocation);

	public boolean delete(Long id);

	public boolean delete(URI location);

}
