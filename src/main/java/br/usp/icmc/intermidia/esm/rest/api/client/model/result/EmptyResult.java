package br.usp.icmc.intermidia.esm.rest.api.client.model.result;

public class EmptyResult extends Result {

	private static final long serialVersionUID = 1796083789567394303L;
	
	private long emptyIntervention;
	
	public EmptyResult() {
		this.setType("empty");
	}

	public long getEmptyIntervention() {
		return emptyIntervention;
	}

	public void setEmptyIntervention(long emptyIntervention) {
		this.emptyIntervention = emptyIntervention;
	}

}
