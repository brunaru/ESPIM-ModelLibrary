package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import java.net.URI;

public class QuestionResult extends Result {

	public static final String ANSWER_SEPARATOR = "_SEP_";

	private URI question;
	
	private String answer;
	
	public QuestionResult() {
		this.setType("question");
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	protected URI getQuestion() {
		return question;
	}

	protected void setQuestion(URI question) {
		this.question = question;
	}

}
