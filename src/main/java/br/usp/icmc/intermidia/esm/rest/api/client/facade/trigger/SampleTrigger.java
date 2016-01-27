package br.usp.icmc.intermidia.esm.rest.api.client.facade.trigger;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.AbstractJsonModel;

public class SampleTrigger extends AbstractJsonModel {
	
	/** Time type trigger. */
	public static final int TYPE_TIME = 0;
	
	/** Manual type trigger. */
	public static final int TYPE_MANUAL = 1;
	
	/** Contextual type trigger. */
	public static final int TYPE_CONTEXTUAL = 2;
	
	/** Time, manual or contextual. */
	private int sampleType;
	
	private String triggerCondition;

	public int getSampleType() {
		return sampleType;
	}

	public void setSampleType(int sampleType) {
		this.sampleType = sampleType;
	}

	public String getTriggerCondition() {
		return triggerCondition;
	}

	public void setTriggerCondition(String triggerCondition) {
		this.triggerCondition = triggerCondition;
	}

}
