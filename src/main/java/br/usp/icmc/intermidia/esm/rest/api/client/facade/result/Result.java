package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import java.util.Date;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.AbstractJsonModel;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.sample.Sample;

public abstract class Result extends AbstractJsonModel {
	
	private Date started;
	
	private Date ended;
	
	private Sample sample;

	public Date getStarted() {
		return started;
	}

	public void setStarted(Date started) {
		this.started = started;
	}

	public Sample getSample() {
		return sample;
	}

	public void setSample(Sample sample) {
		this.sample = sample;
	}

	public Date getEnded() {
		return ended;
	}

	public void setEnded(Date ended) {
		this.ended = ended;
	}
	
}
