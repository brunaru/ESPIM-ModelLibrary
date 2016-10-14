package br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention;

public class MediaIntervention extends Intervention {

public static final String MEDIA_TYPE_IMAGE = "image";
	
	public static final String MEDIA_TYPE_AUDIO = "audio";
	
	public static final String MEDIA_TYPE_VIDEO = "video";

	/** IMAGE, VIDEO or AUDIO. */
	private String mediaType;
	
	public MediaIntervention() {
		this.setType("media");
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	
}
