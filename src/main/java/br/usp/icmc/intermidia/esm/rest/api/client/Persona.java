package br.usp.icmc.intermidia.esm.rest.api.client;

import java.net.URI;
import java.util.List;

public class Persona {

	private String firstName;

	private String lastName;

	private List<URI> movies;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<URI> getMovies() {
		return movies;
	}

	public void setMovies(List<URI> movies) {
		this.movies = movies;
	}
}
