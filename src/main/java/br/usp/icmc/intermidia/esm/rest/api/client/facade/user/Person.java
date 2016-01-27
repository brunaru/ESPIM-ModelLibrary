package br.usp.icmc.intermidia.esm.rest.api.client.facade.user;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.AbstractJsonModel;

public class Person extends AbstractJsonModel {

	private String name;

	private String email;

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
	
}
