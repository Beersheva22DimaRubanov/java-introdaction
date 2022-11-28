package telran;

public class Strings {
	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return true if str2 is an anagram of str1 O(n) 1. the same length 2. the
	 *         same symbols just in different order
	 */
	public static boolean isAnagram(String str1, String str2) {
		boolean res = false;
		if (str1.length() == str2.length()) {
			res = true;
			byte[] helper = new byte[Byte.MAX_VALUE];
			fillHelper(helper, str1);
			int index = 0;
			int length = str1.length();
			while (index < length && res) {
				int indSymb = (int) str2.charAt(index);
				if (helper[indSymb] == 0) {
					res = false;
				} else {
					index++;
					helper[indSymb]--;
				}
			}
		}
		return res;
	}

	private static void fillHelper(byte[] helper, String str1) {
		int length = str1.length();
		for (int i = 0; i < length; i++) {
			int ind = str1.charAt(i);
			helper[ind]++;
		}
	}

	public static void sortStringNumbers(String[] array) {
		int offset = Byte.MAX_VALUE + 1;
		int[] helper = new int[offset * 2];
		fillHelper(helper, array, offset);
		sortFromHelper(array, helper, offset);

	}

	private static void sortFromHelper(String[] array, int[] helper, int offset) {
		int arrayInd = 0;
		for (int i = 0; i < helper.length; i++) {
			for (int j = 0; j < helper[i]; j++) {
				array[arrayInd++] = getStringNumberFromIndex(i, offset);
			}
		}

	}

	private static String getStringNumberFromIndex(int index, int offset) {
		int number = index - offset;
		return Integer.toString(number);
	}

	private static void fillHelper(int[] helper, String[] array, int offset) {
		for (int i = 0; i < array.length; i++) {
			int index = getIndexFromStringNumber(array[i], offset);
			helper[index]++;
		}
	}

	private static int getIndexFromStringNumber(String string, int offset) {
		int number = Integer.parseInt(string);
		return number + offset;
	}

	public static String javaNameExp() {

		return "[a-zA-Z$][\\w$]*|_[\\w$]+";
	}

	public static String ipV40ctet() {
		return "(2([0-4][0-9]|5[0-5])|[01]\\d\\d|[0-9]{1,2})";
	}

	public static String ipV4() {
		String octetExp = ipV40ctet();
		return String.format("(%1$s\\.){3}%1$s", octetExp);
	}

	private static String arithmeticExpression() {
		String operatorExp = operator();
		String operandExp = operand();
		return String.format("^\\(*%1$s\\)*(%2$s\\(*%1$s\\)*)*$", operandExp, operatorExp);
	}

	private static String operand() {
		return "(\\d+\\.?\\d*|\\.\\d+|[a-z])";
	}

	private static String operator() {
		return "([-+*/%])";
	}

	public static boolean isArithmeticExpression(String expression) {
		expression = expression.replaceAll("\\s+", "");
		return expression.matches(arithmeticExpression());
	}

	/**
	 * 
	 * @param expression
	 * @param values
	 * @param namesSorted - variables names sorted by strings
	 * @return computed value of a given expression or Double.NaN
	 */
	public static Double computeArithmeticExpression(String expression, double values[], String names[]) {
		Double res = Double.NaN;
		if (isArithmeticExpression(expression) && checkBraces(expression)) {
			expression = expression.replaceAll("[\\s()]+", "");
			String operands[] = expression.split(operator());
			String operators[] = expression.split(operand());
			res = getOperandValue(operands[0], values, names);
			int index = 1;
			while (index < operands.length && !res.isNaN()) {
				double operandValue = getOperandValue(operands[index], values, names);
				res = computeOperation(res, operandValue, operators[index]);
				index++;
			}
		}
		return res;
	}

	private static Double computeOperation(Double operand1, double operand2, String operator) {
		Double res = Double.NaN;
		if (!Double.isNaN(operand2)) {
			switch (operator) {
			case "+":
				res = operand1 + operand2;
				break;
			case "-":
				res = operand1 - operand2;
				break;
			case "*":
				res = operand1 * operand2;
				break;
			case "/":
				res = operand1 / operand2;
				break;
			default:
				res = Double.NaN;
			}
		}
		return res;
	}

	private static Double getOperandValue(String operand, double[] values, String[] names) {
		double res = Double.NaN;
		if (names != null && operand.matches("[a-z]")) {
			int left = 0;
			int right = names.length - 1;
			int midle = names.length / 2;
			while (left <= right && !operand.equals(names[left])) {
				if (operand.compareTo(names[midle]) <= 0) {
					right = midle - 1;
				} else {
					left = midle + 1;
				}
				midle = left+right/2;
			}
			if (left<names.length && names[left].equals(operand)) {
				res = values[left];
			} else
				res = Double.NaN;
		} else
			res = Double.parseDouble(operand);
		return res;
	}

	private static boolean checkBraces(String expression) {
		int count = 0;
		char[] array = expression.toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '(') {
				count++;
			} else if (array[i] == ')') {
				count--;
			}
		}
		return count == 0;
	}
}
