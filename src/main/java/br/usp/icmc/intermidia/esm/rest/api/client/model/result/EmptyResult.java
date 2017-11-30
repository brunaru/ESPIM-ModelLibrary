package br.usp.icmc.intermidia.esm.rest.api.client.model.result;

public class EmptyResult extends Result {

	private static final long serialVersionUID = 1796083789567394303L;
	
	private long empty;
	
	public EmptyResult() {
		this.setType("empty");
	}

	public long getEmpty() {
		return empty;
	}

	public void setEmpty(long empty) {
		this.empty = empty;
	}

}
