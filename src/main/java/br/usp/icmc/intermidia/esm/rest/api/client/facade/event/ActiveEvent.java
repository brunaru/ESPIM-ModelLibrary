package br.usp.icmc.intermidia.esm.rest.api.client.facade.event;
import java.net.URI;
import java.util.List;

public class ActiveEvent extends Event {
	
	private List<URI> interventions;
	
	public ActiveEvent() {
		this.setType("active");
	}

	public List<URI> getInterventions() {
		return interventions;
	}

	protected void setInterventions(List<URI> interventions) {
		this.interventions = interventions;
	}
	
}
