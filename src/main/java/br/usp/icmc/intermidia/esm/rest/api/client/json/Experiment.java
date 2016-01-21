package br.usp.icmc.intermidia.esm.rest.api.client.json;

import java.net.URI;
import java.util.List;

public class Experiment {

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

	public List<URI> getResearchers() {
		return researchers;
	}

	public void setResearchers(List<URI> researchers) {
		this.researchers = researchers;
	}

	public List<URI> getParticipants() {
		return participants;
	}

	public void setParticipants(List<URI> participants) {
		this.participants = participants;
	}

	public List<URI> getSamples() {
		return samples;
	}

	public void setSamples(List<URI> samples) {
		this.samples = samples;
	}

}
