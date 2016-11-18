package br.usp.icmc.intermidia.esm.rest.api.client.facade.user;

public class Observer extends Person {
	
	private String password;
	
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

}
