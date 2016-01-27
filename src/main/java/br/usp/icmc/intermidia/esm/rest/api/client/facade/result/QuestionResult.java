package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import java.net.URI;

public class QuestionResult extends Result {

	private URI question;
	
	private String answer;	

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public URI getQuestion() {
		return question;
	}

	public void setQuestion(URI question) {
		this.question = question;
	}

}
