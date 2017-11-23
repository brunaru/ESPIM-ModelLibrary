package br.usp.icmc.intermidia.esm.rest.api.client.model.intervention;

public class MediaIntervention extends Intervention {

	private static final long serialVersionUID = -5248201172476153580L;

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
