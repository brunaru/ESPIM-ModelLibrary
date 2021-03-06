package br.usp.icmc.intermidia.esm.rest.api.client.model.intervention;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionIntervention extends Intervention {

	private static final long serialVersionUID = 4862690165851605678L;
	
	public static final int QUESTION_TYPE_OPEN_TEXT = 0;	
	public static final int QUESTION_TYPE_RADIO = 1;	
	public static final int QUESTION_TYPE_CHECKBOX = 2;
	public static final int QUESTION_TYPE_LIKERT = 3;
	public static final int QUESTION_TYPE_LIKERT_CUSTOM = 31;
	public static final int QUESTION_TYPE_SEMANTIC_DIFFERENTIAL = 4;
	
	/** OPEN TEXT, RADIO, CHECKBOX, LIKERT or SEMANTIC DIFFERENTIAL. */
	private int questionType;
	
	private List<String> options = new ArrayList<>();
	
	private Map<String, Integer> conditions = new HashMap<>();
	
	private List<String> scales;
	
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

	public Map<String, Integer> getConditions() {
		return conditions;
	}

	public void setConditions(Map<String, Integer> conditions) {
		this.conditions = conditions;
	}

	public List<String> getScales() {
		return scales;
	}

	public void setScales(List<String> scales) {
		this.scales = scales;
	}
	
}
