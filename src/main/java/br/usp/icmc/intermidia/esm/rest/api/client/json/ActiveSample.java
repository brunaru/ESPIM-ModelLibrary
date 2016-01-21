package br.usp.icmc.intermidia.esm.rest.api.client.json;
import java.net.URI;
import java.util.List;

public class ActiveSample extends Sample {
	
	private List<URI> interventions;
	
	public ActiveSample() {
		this.setType("active");
	}

	public List<URI> getInterventions() {
		return interventions;
	}

	public void setInterventions(List<URI> interventions) {
		this.interventions = interventions;
	}
	
}
