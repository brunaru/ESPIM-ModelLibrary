package br.usp.icmc.intermidia.esm.rest.api.client.facade;

import java.net.URI;
import java.util.List;

public interface RestFacade<T> {
	
	public T get(Long id, boolean verbose);

	public T get(URI location);

	public List<T> getAll();
	
	public T findByValue(String value, String findString, String resource);
	
	public List<T> findMultipleByValue(String value, String findString, String resource);
	
	public String post(T object, boolean verbose);
	
	public boolean put(T object, Long id, boolean verbose);

	public boolean put(T object, String url);

	public boolean patch(T object, URI location);

	public boolean delete(Long id);

	public boolean delete(URI location);

}
