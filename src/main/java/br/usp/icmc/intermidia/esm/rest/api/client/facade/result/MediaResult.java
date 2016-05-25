package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import java.net.URI;
import java.sql.Blob;

public class MediaResult extends Result {

	private URI media;
	
	private Blob resultData;

	public MediaResult() {
		this.setType("media");
	}

	public URI getMedia() {
		return media;
	}

	protected void setMedia(URI media) {
		this.media = media;
	}

	public Blob getResultData() {
		return resultData;
	}

	public void setResultData(Blob resultData) {
		this.resultData = resultData;
	}
	
}
