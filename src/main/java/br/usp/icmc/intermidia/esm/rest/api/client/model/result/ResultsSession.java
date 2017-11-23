package br.usp.icmc.intermidia.esm.rest.api.client.model.result;

import br.usp.icmc.intermidia.esm.rest.api.client.model.AbstractJsonModel;

import java.util.List;

public class ResultsSession extends AbstractJsonModel {
	
	private static final long serialVersionUID = 2043151425202057046L;

	long participant;
	
	long event;
	
	String started = "";
	
	String ended = "";
	
	List<Result> results;

	public long getParticipant() {
		return participant;
	}

	public void setParticipant(long participant) {
		this.participant = participant;
	}

	public long getEvent() {
		return event;
	}

	public void setEvent(long event) {
		this.event = event;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public String getStarted() {
		return started;
	}

	public void setStarted(String started) {
		this.started = started;
	}

	public String getEnded() {
		return ended;
	}

	public void setEnded(String ended) {
		this.ended = ended;
	}

}
