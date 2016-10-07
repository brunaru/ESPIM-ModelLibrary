package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import java.net.URI;

public class MediaResult extends Result {

	private URI media;
	
	private String urlForDataFile;

	public MediaResult() {
		this.setType("media");
	}

	protected URI getMedia() {
		return media;
	}

	protected void setMedia(URI media) {
		this.media = media;
	}

	public String getUrlForDataFile() {
		return urlForDataFile;
	}

	public void setUrlForDataFile(String urlForDataFile) {
		this.urlForDataFile = urlForDataFile;
	}
	
}
