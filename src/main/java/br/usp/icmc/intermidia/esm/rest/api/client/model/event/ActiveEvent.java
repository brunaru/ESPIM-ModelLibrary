package br.usp.icmc.intermidia.esm.rest.api.client.model.event;
import br.usp.icmc.intermidia.esm.rest.api.client.model.intervention.Intervention;

import java.util.List;

public class ActiveEvent extends Event {

	private static final long serialVersionUID = -9214640068659813462L;
	
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
