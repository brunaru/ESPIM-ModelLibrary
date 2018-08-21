package br.usp.icmc.intermidia.esm.rest.api.client.model.user;

import br.usp.icmc.intermidia.esm.rest.api.client.model.AbstractJsonModel;

public class Person extends AbstractJsonModel {

	private static final long serialVersionUID = 5049047871237123233L;

	private String name;

	private String email;
	
	private String phoneNumber;
	
	private String profilePhotoUrl;

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProfilePhotoUrl() {
		return profilePhotoUrl;
	}

	public void setProfilePhotoUrl(String profilePhotoUrl) {
		this.profilePhotoUrl = profilePhotoUrl;
	}

}
