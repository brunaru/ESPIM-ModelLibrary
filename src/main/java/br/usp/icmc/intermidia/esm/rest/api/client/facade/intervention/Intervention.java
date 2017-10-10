package br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.AbstractJsonModel;


@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.EXISTING_PROPERTY,
	    property = "type")
@JsonSubTypes({ 
	@Type(value = QuestionIntervention.class, name = "question"),
	@Type(value = TaskIntervention.class, name = "task"),
	@Type(value = EmptyIntervention.class, name = "empty"),
	@Type(value = MediaIntervention.class, name = "media"), 
	})
public abstract class Intervention extends AbstractJsonModel {
	
	private String type;
	
	private String statement;
	
	private List<MediaPresentation> medias = new ArrayList<>();
	
	private int orderPosition;
	
	private boolean first;
	
	private int next;
	
	private boolean obligatory;

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public boolean isObligatory() {
		return obligatory;
	}

	public void setObligatory(boolean obligatory) {
		this.obligatory = obligatory;
	}

	public int getOrderPosition() {
		return orderPosition;
	}

	public void setOrderPosition(int orderPosition) {
		this.orderPosition = orderPosition;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public boolean getFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public List<MediaPresentation> getMedias() {
		return medias;
	}

	public void setMedias(List<MediaPresentation> medias) {
		this.medias = medias;
	}

}
