package br.usp.icmc.intermidia.esm.rest.api.client.facade.trigger;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.AbstractJsonModel;

public class EventTrigger extends AbstractJsonModel {
	
	/** Time type trigger. */
	public static final String TYPE_TIME = "time";
	
	/** Manual type trigger. */
	public static final String TYPE_MANUAL = "manual";
	
	/** Contextual type trigger. */
	public static final String TYPE_CONTEXTUAL = "contextual";
	
	/** Time, manual or contextual. */
	private String triggerType;
	
	private String triggerCondition;

	public String getTriggerCondition() {
		return triggerCondition;
	}

	public void setTriggerCondition(String triggerCondition) {
		this.triggerCondition = triggerCondition;
	}

	public String getTriggerType() {
		return triggerType;
	}

	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}

}
