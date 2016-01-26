package br.usp.icmc.intermidia.esm.rest.api.client.facade;

import java.net.URI;
import java.util.Map;

public class AbstractJsonModel {
	
	private Map<String, URI> links;

	public Map<String, URI> getLinks() {
		return links;
	}

	public void setLinks(Map<String, URI> links) {
		this.links = links;
	}

}
