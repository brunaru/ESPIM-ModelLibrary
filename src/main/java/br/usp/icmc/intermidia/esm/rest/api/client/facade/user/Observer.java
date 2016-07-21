package br.usp.icmc.intermidia.esm.rest.api.client.facade.user;
import java.net.URI;
import java.util.List;

public class Observer extends Person {
	
	private String password;
	
	private List<URI> contacts;
	
	String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	protected List<URI> getContacts() {
		return contacts;
	}

	protected void setContacts(List<URI> contacts) {
		this.contacts = contacts;
	}

}
