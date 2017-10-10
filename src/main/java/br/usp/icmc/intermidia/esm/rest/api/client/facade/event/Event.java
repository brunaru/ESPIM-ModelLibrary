package br.usp.icmc.intermidia.esm.rest.api.client.facade.event;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.AbstractJsonModel;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.sensor.Sensor;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.trigger.EventTrigger;

@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.EXISTING_PROPERTY,
	    property = "type")
@JsonSubTypes({ 
	@Type(value = ActiveEvent.class, name = "active"), 
	@Type(value = PassiveEvent.class, name = "passive"), 
	})
public abstract class Event extends AbstractJsonModel {

	private String type;

	private String title;

	private String description;

	private List<EventTrigger> triggers;

	private List<Sensor> sensors = new ArrayList<>();

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
}
