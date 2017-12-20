package br.usp.icmc.intermidia.esm.rest.api.client.model.user;

import java.util.ArrayList;
import java.util.List;

public class Observer extends Person {

	private static final long serialVersionUID = 1943269695534362784L;
	
	String role;
	
	private List<Person> contacts = new ArrayList<Person>();

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public List<Person> getContacts() {
		return contacts;
	}

	public void setContacts(List<Person> contacts) {
		this.contacts = contacts;
	}

}
