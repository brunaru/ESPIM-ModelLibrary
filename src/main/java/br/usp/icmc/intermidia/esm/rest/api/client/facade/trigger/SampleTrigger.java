package br.usp.icmc.intermidia.esm.rest.api.client.facade.trigger;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.AbstractJsonModel;

public class SampleTrigger extends AbstractJsonModel {
	
	/** Time type trigger. */
	public static final String TYPE_TIME = "time";
	
	/** Manual type trigger. */
	public static final String TYPE_MANUAL = "manual";
	
	/** Contextual type trigger. */
	public static final String TYPE_CONTEXTUAL = "contextual";
	
	/** Time, manual or contextual. */
	private String sampleType;
	
	private String triggerCondition;

	public String getSampleType() {
		return sampleType;
	}

	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}

	public String getTriggerCondition() {
		return triggerCondition;
	}

	public void setTriggerCondition(String triggerCondition) {
		this.triggerCondition = triggerCondition;
	}

}
