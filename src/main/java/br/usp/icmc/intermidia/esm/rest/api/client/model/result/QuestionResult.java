package br.usp.icmc.intermidia.esm.rest.api.client.model.result;

public class QuestionResult extends Result {

	private static final long serialVersionUID = -7546755303034829519L;

	public static final String ANSWER_SEPARATOR = "_SEP_";
	
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

}
