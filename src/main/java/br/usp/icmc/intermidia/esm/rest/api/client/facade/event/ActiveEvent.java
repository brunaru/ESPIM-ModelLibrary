package br.usp.icmc.intermidia.esm.rest.api.client.facade.event;
import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention.Intervention;

public class ActiveEvent extends Event {
	
	private List<Intervention> interventions;
	
	public ActiveEvent() {
		this.setType("active");
	}

	public List<Intervention> getInterventions() {
		return interventions;
	}

	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}
	
}
