package br.usp.icmc.intermidia.esm.rest.api.client.json;

public abstract class Intervention {
	
	private String type;
	
	private String statment;
	
	private int orderPosition;
	
	private boolean obligatory;
	
	private String showCondition;

	public String getStatment() {
		return statment;
	}

	public void setStatment(String statment) {
		this.statment = statment;
	}

	public boolean isObligatory() {
		return obligatory;
	}

	public void setObligatory(boolean obligatory) {
		this.obligatory = obligatory;
	}

	public int getOrderPosition() {
		return orderPosition;
	}

	public void setOrderPosition(int orderPosition) {
		this.orderPosition = orderPosition;
	}

	public String getShowCondition() {
		return showCondition;
	}

	public void setShowCondition(String showCondition) {
		this.showCondition = showCondition;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
