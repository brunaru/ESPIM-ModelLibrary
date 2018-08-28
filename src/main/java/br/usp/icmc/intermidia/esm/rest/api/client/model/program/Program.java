package br.usp.icmc.intermidia.esm.rest.api.client.model.program;

import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.model.AbstractJsonModel;
import br.usp.icmc.intermidia.esm.rest.api.client.model.event.Event;
import br.usp.icmc.intermidia.esm.rest.api.client.model.user.Observer;
import br.usp.icmc.intermidia.esm.rest.api.client.model.user.Person;

public class Program extends AbstractJsonModel {

	private static final long serialVersionUID = 6627841709629362555L;

	private String title;

	private String description;

	private List<Observer> observers;

	private List<Person> participants;

	private List<Event> events;
	
	/** When it starts: timestamp.  */
	private String starts = "";
	
	/** When it ends: timestamp.  */
	private String ends = "";
	
	/** When it was updated: timestamp.  */
	private String updateDate;
	
	private boolean hasPhases = false;
	
	private boolean isPublic = false;

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

	public List<Observer> getObservers() {
		return observers;
	}

	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}

	public List<Person> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Person> participants) {
		this.participants = participants;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public boolean isHasPhases() {
		return hasPhases;
	}

	public void setHasPhases(boolean hasPhases) {
		this.hasPhases = hasPhases;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
}
