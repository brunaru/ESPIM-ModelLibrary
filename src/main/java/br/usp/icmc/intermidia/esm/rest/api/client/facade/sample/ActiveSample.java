package br.usp.icmc.intermidia.esm.rest.api.client.facade.sample;
import java.net.URI;
import java.util.List;

public class ActiveSample extends Sample {
	
	private List<URI> interventions;
	
	public ActiveSample() {
		this.setType("active");
	}

	protected List<URI> getInterventions() {
		return interventions;
	}

	protected void setInterventions(List<URI> interventions) {
		this.interventions = interventions;
	}
	
}
