package br.usp.icmc.intermidia.esm.rest.api.client.model.condition;

import br.usp.icmc.intermidia.esm.rest.api.client.model.AbstractJsonModel;

public class ComplexCondition extends AbstractJsonModel {

	private static final long serialVersionUID = 8177288453524037769L;

	private String dependentConditions;

	private String action;

	public String getDependentConditions() {
		return dependentConditions;
	}

	public void setDependentConditions(String dependentConditions) {
		this.dependentConditions = dependentConditions;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
