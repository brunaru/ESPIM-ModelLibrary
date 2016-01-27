package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import java.net.URI;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class MediaResultRestFacade extends GenericRestFacade<MediaResult> implements RestFacade<MediaResult> {

	private static final String RESOURCE = "media-results";
	/* Relationships */
	private static final String MEDIA = "media";

	private static final String[] linkNames = { MEDIA };

	public MediaResultRestFacade() {
		super(RESOURCE, linkNames);
	}

	@Override
	public URI putRelationship(URI objectLocation, URI relationshipLocation) {
		MediaResult mediaResult = get(objectLocation);
		mediaResult.setMedia(relationshipLocation);
		return put(mediaResult, objectLocation);
	}

}
