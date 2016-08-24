package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import java.net.URI;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.AbstractJsonModel;

public abstract class Result extends AbstractJsonModel {
	
	private String type;
	
	private String started;
	
	private String ended;
	
	private URI participant;

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

	protected URI getParticipant() {
		return participant;
	}

	protected void setParticipant(URI participant) {
		this.participant = participant;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
