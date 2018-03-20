package br.usp.icmc.intermidia.esm.rest.api.client.model.result;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import br.usp.icmc.intermidia.esm.rest.api.client.model.AbstractJsonModel;

@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.EXISTING_PROPERTY,
	    property = "type")
@JsonSubTypes({ 
	@Type(value = QuestionResult.class, name = "question"),
	@Type(value = TaskResult.class, name = "task"),
	@Type(value = SensorResult.class, name = "sensor"),
	@Type(value = MediaResult.class, name = "media"),
	@Type(value = EmptyResult.class, name = "empty"),
	})
public abstract class Result extends AbstractJsonModel {
	
	private static final long serialVersionUID = -1965892150012913454L;

	private String type;
	
	private String started;
	
	private String ended;
	
	private long intervention;

	public String getStarted() {
		return started;
	}

	public void setStarted(String started) {
		this.started = started;
	}

	public String getEnded() {
		return ended;
	}

	public void setEnded(String ended) {
		this.ended = ended;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getIntervention() {
		return intervention;
	}

	public void setIntervention(long intervention) {
		this.intervention = intervention;
	}
	
}
