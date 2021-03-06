package br.usp.icmc.intermidia.esm.rest.api.client.model.trigger;

import br.usp.icmc.intermidia.esm.rest.api.client.model.AbstractJsonModel;

public class EventTrigger extends AbstractJsonModel {
	
	private static final long serialVersionUID = 7574319349635160297L;

	/** Time type trigger. */
	public static final String TYPE_TIME = "time";
	
	/** Manual type trigger. */
	public static final String TYPE_MANUAL = "manual";
	
	/** Contextual type trigger. */
	public static final String TYPE_CONTEXTUAL = "contextual";
	
	/** Time, manual or contextual. */
	private String triggerType;
	
	private String triggerCondition;
	
	private String priority;
	
	private int timeOut;

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

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

}
