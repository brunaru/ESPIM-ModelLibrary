package br.usp.icmc.intermidia.esm.rest.api.client.facade;

import java.io.Serializable;

public class AbstractJsonModel implements Serializable {
	
	private static final long serialVersionUID = 6655957309023683690L;
	private Long id = (long) 0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
