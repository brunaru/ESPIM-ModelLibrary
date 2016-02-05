package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import java.net.URI;
import java.util.Date;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.AbstractJsonModel;

public abstract class Result extends AbstractJsonModel {
	
	private String type;
	
	private Date started;
	
	private Date ended;
	
	private URI participant;

	public Date getStarted() {
		return started;
	}

	public void setStarted(Date started) {
		this.started = started;
	}

	public Date getEnded() {
		return ended;
	}

	public void setEnded(Date ended) {
		this.ended = ended;
	}

	public URI getParticipant() {
		return participant;
	}

	public void setParticipant(URI participant) {
		this.participant = participant;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
