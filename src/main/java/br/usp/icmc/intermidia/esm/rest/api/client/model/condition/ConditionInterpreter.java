package br.usp.icmc.intermidia.esm.rest.api.client.model.condition;

public class ConditionInterpreter {

	/**
	 * OPERATIONS
	 */
	public static final String OP_MISSED = "MISSED";
	public static final String OP_COMPLETED = "COMPLETED";

	/**
	 * OPERATORS
	 */
	public static final String EQUALS = "EQUALS";
	public static final String GREATER_THAN = "GREATER_THAN";
	public static final String LESS_THAN = "LESS_THAN";
	
	public static boolean checkAllConditions(String condition, int missedTimes, int attempts) {
		String[] ands = condition.split("\\s* AND \\s*");
		for (int i = 0; i < ands.length; i++) {
			boolean check = false;
			if (ands[i].contains(OP_MISSED)) {
				check = checkMissed(ands[i], missedTimes);
			} else if (ands[i].contains(OP_COMPLETED)) {
				check = checkCompleted(ands[i], attempts);
			}
			if (check == false) {
				return false;
			}
		}
		return true;
	}

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

	public static boolean checkCompleted(String condition, int value) {
		try {
			if (condition.contains(OP_COMPLETED)) {
				String[] ops = condition.split("\\s+");
				return checkComparisonCondition(ops[1], Integer.valueOf(ops[2]), value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private static boolean checkComparisonCondition(String operator, int conditionStringValue, int value) {
		if (operator.contains(EQUALS)) {
			if (value == conditionStringValue) {
				return true;
			}

		} else if (operator.contains(GREATER_THAN)) {
			if (value > conditionStringValue) {
				return true;
			}
		} else if (operator.contains(LESS_THAN)) {
			if (value < conditionStringValue) {
				return true;
			}
		}
		return false;
	}

}
