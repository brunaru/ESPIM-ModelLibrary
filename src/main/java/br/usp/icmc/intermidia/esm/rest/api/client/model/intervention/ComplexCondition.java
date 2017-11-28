package br.usp.icmc.intermidia.esm.rest.api.client.model.intervention;

import br.usp.icmc.intermidia.esm.rest.api.client.model.AbstractJsonModel;

public class ComplexCondition extends AbstractJsonModel {

	private static final long serialVersionUID = 8177288453524037769L;

	private String value;

	private String type;

	private String condition;

	private int next;

	private String action;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}