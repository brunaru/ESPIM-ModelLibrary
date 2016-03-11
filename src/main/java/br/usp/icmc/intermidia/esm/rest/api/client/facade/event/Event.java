package br.usp.icmc.intermidia.esm.rest.api.client.facade.event;

import java.net.URI;
import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.AbstractJsonModel;

public abstract class Event extends AbstractJsonModel {
	
	private String type;
	
	private String title;
	
	private String description;

	private List<URI> triggers;
	
	private List <URI> sensors;
	
	private List <URI> results;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	protected List<URI> getTriggers() {
		return triggers;
	}

	protected void setTriggers(List<URI> triggers) {
		this.triggers = triggers;
	}

	protected List<URI> getSensors() {
		return sensors;
	}

	protected void setSensors(List<URI> sensors) {
		this.sensors = sensors;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	protected List <URI> getResults() {
		return results;
	}

	protected void setResults(List <URI> results) {
		this.results = results;
	}

}