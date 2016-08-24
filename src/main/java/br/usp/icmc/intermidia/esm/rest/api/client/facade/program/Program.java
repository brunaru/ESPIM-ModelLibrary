package br.usp.icmc.intermidia.esm.rest.api.client.facade.program;

import java.net.URI;
import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.AbstractJsonModel;

public class Program extends AbstractJsonModel {

	private String title;

	private String description;

	private List<URI> observers;

	private List<URI> participants;

	private List<URI> events;
	
	/** When it starts: timestamp.  */
	private String starts;
	
	/** When it ends: timestamp.  */
	private String ends;
	
	/** When it was updated: timestamp.  */
	private String updateDate;

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

	protected List<URI> getObservers() {
		return observers;
	}

	protected void setObservers(List<URI> observers) {
		this.observers = observers;
	}

	protected List<URI> getParticipants() {
		return participants;
	}

	protected void setParticipants(List<URI> participants) {
		this.participants = participants;
	}

	protected List<URI> getEvents() {
		return events;
	}

	protected void setEvents(List<URI> events) {
		this.events = events;
	}

	public String getStarts() {
		return starts;
	}

	public void setStarts(String starts) {
		this.starts = starts;
	}

	public String getEnds() {
		return ends;
	}

	public void setEnds(String ends) {
		this.ends = ends;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
}
