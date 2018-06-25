package br.usp.icmc.intermidia.esm.rest.api.client.model.event;

import java.util.ArrayList;
import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.model.AbstractJsonModel;
import br.usp.icmc.intermidia.esm.rest.api.client.model.condition.ComplexCondition;
import br.usp.icmc.intermidia.esm.rest.api.client.model.sensor.Sensor;
import br.usp.icmc.intermidia.esm.rest.api.client.model.trigger.EventTrigger;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.EXISTING_PROPERTY,
	    property = "type")
@JsonSubTypes({ 
	@Type(value = ActiveEvent.class, name = "active"),
	@Type(value = PassiveEvent.class, name = "passive"),
	})
public abstract class Event extends AbstractJsonModel {

	private static final long serialVersionUID = -1253060715558756735L;

	private String type;

	private String title;

	private String description;

	private List<EventTrigger> triggers;

	private List<Sensor> sensors = new ArrayList<>();
	
	private List<ComplexCondition> complexConditions = new ArrayList<>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

	public List<EventTrigger> getTriggers() {
		return triggers;
	}

	public void setTriggers(List<EventTrigger> triggers) {
		this.triggers = triggers;
	}

	public List<ComplexCondition> getComplexConditions() {
		return complexConditions;
	}

	public void setComplexConditions(List<ComplexCondition> complexConditions) {
		this.complexConditions = complexConditions;
	}
}
