package br.usp.icmc.intermidia.esm.rest.api.client.facade.program;

import java.net.URI;
import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.AbstractJsonModel;

public class Program2 extends AbstractJsonModel {

	private String title;

	private String description;

	private List<URI> observers;

	private List<URI> participants;

	private List<URI> events;

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

	public List<URI> getObservers() {
		return observers;
	}

	protected void setObservers(List<URI> observers) {
		this.observers = observers;
	}

	public List<URI> getParticipants() {
		return participants;
	}

	protected void setParticipants(List<URI> participants) {
		this.participants = participants;
	}

	public List<URI> getEvents() {
		return events;
	}

	protected void setEvents(List<URI> events) {
		this.events = events;
	}
}
