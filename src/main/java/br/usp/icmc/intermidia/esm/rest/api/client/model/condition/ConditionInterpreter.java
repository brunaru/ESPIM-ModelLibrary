package br.usp.icmc.intermidia.esm.rest.api.client.model.condition;

import java.util.List;

public class ConditionInterpreter {

	/**
	 * OPERATIONS
	 */
	public static final String OP_MISSED = "MISSED";
	public static final String OP_ATTEMPTS = "ATTEMPTS";

	/**
	 * OPERATORS
	 */
	public static final String EQUALS = "EQUALS";
	public static final String GREATER_THAN = "GREATER_THAN";
	public static final String LESS_THAN = "LESS_THAN";

	public static boolean checkMissed(String condition, int value) {
		try {
			if (condition.contains(OP_MISSED)) {
				String[] ops = condition.split("\\s+");
				return checkComparisonCondition(ops[1], Integer.valueOf(ops[2]), value);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean checkAttempts(String condition, int value) {
		try {
			if (condition.contains(OP_ATTEMPTS)) {
				String[] ops = condition.split("\\s+");
				return checkComparisonCondition(ops[1], Integer.valueOf(ops[2]), value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private static boolean checkComparisonCondition(String operator, int conditionValue, int value) {
		if (operator.contains(EQUALS)) {
			if (conditionValue == value) {
				return true;
			}

		} else if (operator.contains(GREATER_THAN)) {
			if (conditionValue > value) {
				return true;
			}
		} else if (operator.contains(LESS_THAN)) {
			if (conditionValue < value) {
				return true;
			}
		}
		return false;
	}

}
