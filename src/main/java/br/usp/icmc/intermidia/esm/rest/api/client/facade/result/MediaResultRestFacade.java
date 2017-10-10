package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class MediaResultRestFacade extends ResultRestFacade<MediaResult> implements RestFacade<MediaResult> {

	public static final String RESOURCE = "media-results";
	/* Relationships */
	public static final String MEDIA = "media";

	public MediaResultRestFacade() {
		super(RESOURCE);
	}

}
