package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

public class QuestionResult extends Result {

	public static final String ANSWER_SEPARATOR = "_SEP_";

	private long question;
	
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

	public long getQuestion() {
		return question;
	}

	public void setQuestion(long question) {
		this.question = question;
	}

}
