package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import java.net.URI;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class MediaResultRestFacade extends ResultRestFacade<MediaResult> implements RestFacade<MediaResult> {

	private static final String RESOURCE = "media-results";
	/* Relationships */
	private static final String MEDIA = "media";

	private static final String[] linkNames = { MEDIA, PARTICIPANT };

	public MediaResultRestFacade() {
		super(RESOURCE, linkNames);
	}

	@Override
	public URI putRelationship(URI objectLocation, URI relationshipLocation) {
		String relationship = relationshipLocation.toString();
		if (relationship.contains(PARTICIPANT)) {
			return putParticipantRelationship(objectLocation, relationshipLocation);
		} else if (relationship.contains(MEDIA)) {
			MediaResult mediaResult = get(objectLocation);
			mediaResult.setMedia(relationshipLocation);
			return put(mediaResult, objectLocation);
		} else {
			return null;
		}
	}

}
