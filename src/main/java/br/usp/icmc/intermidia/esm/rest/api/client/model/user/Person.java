package br.usp.icmc.intermidia.esm.rest.api.client.model.user;

import br.usp.icmc.intermidia.esm.rest.api.client.model.AbstractJsonModel;

import java.util.ArrayList;
import java.util.List;

public class Person extends AbstractJsonModel {

	private static final long serialVersionUID = 5049047871237123233L;

	private String name;

	private String email;

	private List<Person> contacts;
	
	public Person() {
		contacts = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Person> getContacts() {
		return contacts;
	}

	public void setContacts(List<Person> contacts) {
		this.contacts = contacts;
	}
}