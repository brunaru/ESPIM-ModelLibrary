package br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention;

import java.util.List;

public class QuestionIntervention extends Intervention {
	
	public static final int QUESTION_TYPE_OPEN_TEXT = 0;	
	public static final int QUESTION_TYPE_RADIO = 1;	
	public static final int QUESTION_TYPE_CHECKBOX = 2;	
	public static final int QUESTION_TYPE_LIKERT = 3;	
	public static final int QUESTION_TYPE_SEMANTIC_DIFFERENTIAL = 4;
	
	/** OPEN TEXT, RADIO, CHECKBOX, LIKERT or SEMANTIC DIFFERENTIAL. */
	private int questionType;
	
	private List<String> options;
	
	public QuestionIntervention() {
		this.setType("question");
	}
	
	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public int getQuestionType() {
		return questionType;
	}

	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}

}
