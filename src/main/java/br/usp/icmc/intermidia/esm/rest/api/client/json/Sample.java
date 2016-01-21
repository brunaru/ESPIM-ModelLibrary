package br.usp.icmc.intermidia.esm.rest.api.client.json;

import java.net.URI;
import java.util.List;

public abstract class Sample {
	
	private String type;
	
	private String title;
	
	private String description;

	private List<URI> triggers;
	
	private List <URI> sensors;
	
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

	public List<URI> getTriggers() {
		return triggers;
	}

	public void setTriggers(List<URI> triggers) {
		this.triggers = triggers;
	}

	public List<URI> getSensors() {
		return sensors;
	}

	public void setSensors(List<URI> sensors) {
		this.sensors = sensors;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
