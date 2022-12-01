package telran.digital.numbers;

public class DigitalNumbersPrint {
	private static final String SYMBOL = "*";
	private static final int THREE_LINES_FIGURE = 3;

	public static void displayDigitalNumber(int number, int offset, int width, int height) {
		int[] digits = getDigitsArray(number);
		String[] res = new String[height];
		for (int i = 0; i < digits.length; i++) {
			switch (digits[i]) {
			case 0:
				res = getResult(res, zero(offset, width, height));
				break;
			case 1:
				res = getResult(res, one(offset, width, height));
				break;
			case 2:
				res = getResult(res, two(offset, width, height));
				break;
			case 3:
				res = getResult(res, three(offset, width, height));
				break;
			case 4:
				res = getResult(res, four(offset, width, height));
				break;
			case 5:
				res = getResult(res, five(offset, width, height));
				break;
			case 6:
				res = getResult(res, six(offset, width, height));
				break;
			case 7:
				res = getResult(res, seven(offset, width, height));
				break;
			case 8:
				res = getResult(res, eight(offset, width, height));
				break;
			case 9:
				res = getResult(res, nine(offset, width, height));
				break;
			}
		}
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	private static int[] getDigitsArray(int number) {
		int[] res = new int[getNumOfDigits(number)];
		int i = res.length - 1;
		while (number != 0) {
			res[i] = number % 10;
			number /= 10;
			i--;
		}
		return res;
	}

	private static int getNumOfDigits(int number) {
		int res = 0;
		while (number != 0) {
			res++;
			number /= 10;
		}
		return res;
	}

	private static String[] getResult(String[] res, String[] array2) {
		for (int i = 0; i < res.length; i++) {
			if (res[i] == null) {
				res[i] = array2[i];
			} else {
				res[i] = res[i] + array2[i];
			}
		}
		return res;
	}

	public static String line(int offset, int length) {
		return " ".repeat(offset) + SYMBOL.repeat(length);
	}

	public static String[] rightVerticalLine(int offset, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL;
		}
		return res;
	}

	private static String[] lefttVerticalLine(int offset, int height, int width) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 1);
		}
		return res;
	}

	public static String[] twoVerticalLines(int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
		}
		return res;
	}

	public static void displayStrings(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		System.out.println();
	}

	public static String[] zero(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = twoVerticalLines(offset, width, height - 2);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static String[] one(int offset, int width, int height) {
		return rightVerticalLine(offset + width - 1, height);
	}


	public static String[] two(int offset, int width, int height) {
		return threeLinesDigitsConstructor(offset, width, height, 2);
	}

	public static String[] three(int offset, int width, int height) {
		return threeLinesDigitsConstructor(offset, width, height, 3);
	}

	public static String[] four(int offset, int width, int height) {
		String[] res = new String[height];
		String[] lines = twoVerticalLines(offset, width, (height - 1) / 2);
		System.arraycopy(lines, 0, res, 0, lines.length);
		res[(height - 1) / 2] = line(offset, width);
		String[] verticleLine = rightVerticalLine(offset + width - 1, (height - 1 - lines.length));
		updateArray(verticleLine, 0, res, (height + 1) / 2, verticleLine.length);
		return res;
	}

	public static String[] five(int offset, int width, int height) {
		return threeLinesDigitsConstructor(offset, width, height, 5);
	}

	public static String[] six(int offset, int width, int height) {
		return threeLinesDigitsConstructor(offset, width, height, 6);
	}

	public static String[] seven(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] line = rightVerticalLine(offset + width - 1, height - 1);
		updateArray(line, 0, res, 1, line.length);
		return res;
	}

	public static String[] eight(int offset, int width, int height) {
		return threeLinesDigitsConstructor(offset, width, height, 8);
	}
	

	public static String[] nine(int offset, int width, int height) {
		return threeLinesDigitsConstructor(offset, width, height, 9);
	}

	private static String[] threeLinesDigitsConstructor(int offset, int width, int height, int digit) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		int length = 0;
		if(digit == 8 || digit == 9) {
			String[] firstLine = twoVerticalLines(offset, width, (height - THREE_LINES_FIGURE) / 2);
			updateArray(firstLine, 0, res, 1, firstLine.length);
			length = firstLine.length;
		} else if (digit == 2 || digit == 3 ) {
			String[] firstLine = rightVerticalLine(offset + width - 1, (height - THREE_LINES_FIGURE) / 2);
			updateArray(firstLine, 0, res, 1, firstLine.length);
			length = firstLine.length;
		} else if(digit == 5|| digit == 6) {
			String[] firstLine = lefttVerticalLine(offset, (height - THREE_LINES_FIGURE) / 2, width);
			updateArray(firstLine, 0, res, 1, firstLine.length);
			length = firstLine.length;
		}
		res[(height - 1) / 2] = line(offset, width);
		if(digit == 3 || digit == 9 || digit == 5) {
			String[] secondLine = rightVerticalLine(offset + width - 1, 
					height - THREE_LINES_FIGURE - length);
			updateArray(secondLine, 0, res, (height + 1) / 2, secondLine.length);
		} else if (digit == 8 || digit == 6) {
			String[] secondLine = twoVerticalLines(offset, width, 
					height - THREE_LINES_FIGURE - length);
			updateArray(secondLine, 0, res, (height + 1) / 2, secondLine.length);
		} else if (digit == 2) {
			String[] secondLine = lefttVerticalLine(offset, 
					height - THREE_LINES_FIGURE - length, width);
			updateArray(secondLine, 0, res, (height + 1) / 2, secondLine.length);
		}
		res[height - 1] = line(offset, width);
		return res;
	}
	
	private static void updateArray(String[] array1, int indexFrom, String[] array2, int indexTo, int amount) {
		System.arraycopy(array1, indexFrom, array2, indexTo, amount);
	}

}
