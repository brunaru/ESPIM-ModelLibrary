package br.usp.icmc.intermidia.esm.rest.api.client.facade.program;

import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.model.program.Program;

public class ProgramRestFacade extends GenericRestFacade<Program> implements RestFacade<Program> {

	public static final String RESOURCE = "programs";
	/* Relationships */
	public static final String PARTICIPANTS = "participants";
	public static final String OBSERVERS = "observers";
	public static final String EVENTS = "events";

	public ProgramRestFacade() {
		super(RESOURCE);
	}
	
	public List<Program> findByParticipantsEmail(String email) {
		return findMultipleByValue(email, "search/findByParticipantsEmail/?email=", RESOURCE);
	}

	public List<Program> findByObserversEmail(String email) {
		return findMultipleByValue(email, "search/findByObserversEmail/?email=", RESOURCE);
	}

}
