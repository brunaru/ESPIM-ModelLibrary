package br.usp.icmc.intermidia.esm.rest.api.client.facade.experiment;

import java.net.URI;
import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.AbstractJsonModel;

public class Experiment extends AbstractJsonModel {

	private String title;

	private String description;

	private List<URI> researchers;

	private List<URI> participants;

	private List<URI> samples;

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

	protected List<URI> getResearchers() {
		return researchers;
	}

	protected void setResearchers(List<URI> researchers) {
		this.researchers = researchers;
	}

	protected List<URI> getParticipants() {
		return participants;
	}

	protected void setParticipants(List<URI> participants) {
		this.participants = participants;
	}

	protected List<URI> getSamples() {
		return samples;
	}

	protected void setSamples(List<URI> samples) {
		this.samples = samples;
	}
}
