package br.usp.icmc.intermidia.esm.rest.api.client.facade.program;

import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.Constants;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

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
		String s = Constants.REST_API_ADDRESS + RESOURCE + "/" + "search/findByParticipantsEmail?email=" + email;
		return findMultipleByEmail(email, s, "findByParticipantsEmail", RESOURCE);
	}

	public List<Program> findByObserversEmail(String email) {
		String s = Constants.REST_API_ADDRESS + RESOURCE + "/" + "search/findByObserversEmail?email=" + email;
		return findMultipleByEmail(email, s, "findByObserversEmail", RESOURCE);
	}

}
