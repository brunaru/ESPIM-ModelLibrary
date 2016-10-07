package br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention;

public class MediaIntervention extends Intervention {

	public static final int MEDIA_TYPE_IMAGE = 0;
	
	public static final int MEDIA_TYPE_AUDIO = 1;
	
	public static final int MEDIA_TYPE_VIDEO = 2;

	/** IMAGE, VIDEO or AUDIO. */
	private int mediaType;
	
	public MediaIntervention() {
		this.setType("media");
	}

	public int getMediaType() {
		return mediaType;
	}

	public void setMediaType(int mediaType) {
		this.mediaType = mediaType;
	}
	
}
