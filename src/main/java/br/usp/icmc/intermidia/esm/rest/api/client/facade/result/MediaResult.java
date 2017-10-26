package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

public class MediaResult extends Result {

	private static final long serialVersionUID = -8009203369253116532L;

	private long media;
	
	private String urlForDataFile;

	public MediaResult() {
		this.setType("media");
	}

	public String getUrlForDataFile() {
		return urlForDataFile;
	}

	public void setUrlForDataFile(String urlForDataFile) {
		this.urlForDataFile = urlForDataFile;
	}

	public long getMedia() {
		return media;
	}

	public void setMedia(long media) {
		this.media = media;
	}
	
}
