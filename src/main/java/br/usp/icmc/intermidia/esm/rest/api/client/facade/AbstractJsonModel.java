package br.usp.icmc.intermidia.esm.rest.api.client.facade;

import java.net.URI;
import java.util.Map;

public class AbstractJsonModel {
	
	private Map<String, URI> links;
	
	private URI selfLocation;

	public Map<String, URI> getLinks() {
		return links;
	}

	protected void setLinks(Map<String, URI> links) {
		this.links = links;
	}

	public URI getSelfLocation() {
		return selfLocation;
	}

	public void setSelfLocation(URI selfLocation) {
		this.selfLocation = selfLocation;
	}

}
