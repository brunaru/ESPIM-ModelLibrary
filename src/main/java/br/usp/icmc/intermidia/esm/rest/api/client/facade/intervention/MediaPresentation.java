package br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.AbstractJsonModel;

public class MediaPresentation extends AbstractJsonModel {

	private static final long serialVersionUID = 4415484299559806642L;

	public static final String MEDIA_TYPE_IMAGE = "image";

	public static final String MEDIA_TYPE_AUDIO = "audio";

	public static final String MEDIA_TYPE_VIDEO = "video";

	private String type;

	private String mediaUrl;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMediaUrl() {
		return mediaUrl;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

}
