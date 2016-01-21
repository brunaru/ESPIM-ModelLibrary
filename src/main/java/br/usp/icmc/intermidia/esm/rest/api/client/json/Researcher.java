package br.usp.icmc.intermidia.esm.rest.api.client.json;
import java.net.URI;
import java.util.List;

public class Researcher extends Person {
	
	private String password;
	
	private List<URI> contacts;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<URI> getContacts() {
		return contacts;
	}

	public void setContacts(List<URI> contacts) {
		this.contacts = contacts;
	}

}
