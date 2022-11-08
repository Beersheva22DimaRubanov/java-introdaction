
public class Numbers {
	public static final int N_HAPPY_NUMBER_DIGITS = 6;

	static public int getNdigits(long number) {
		int res = 0;
		do {
			number /= 10;
			res++;
		} while (number != 0);
		return res;
	}

	/**
	 * 
	 * @param number
	 * @return true only if number comprise of 6 digits and sum of first 3 digits
	 *         equals the sum of last 3 digits
	 */
	static public boolean isHappyNumber(int number) {
				boolean flag = false;
		number = Math.abs(number);
		if (getNdigits(number) == N_HAPPY_NUMBER_DIGITS) {
			int halfDigits = N_HAPPY_NUMBER_DIGITS / 2;
			int numberPartDivider = (int) Math.pow(10, halfDigits);
			int sumFirstPart = getSumOfDigits(number / numberPartDivider);
			flag = sumFirstPart == getSumOfDigits(number % numberPartDivider);
		}
		return flag;
	}

	static private int getSumOfDigits(int number) {
		int res = 0;
		do {
			res += number % 10;
			number /= 10;
		} while (number != 0);
		return res;
	}

	public static int[] getDigits(int number) {
		int res[] = new int[getNdigits(number)];
		for (int i = res.length - 1; i >= 0; i--) {
			res[i] = number % 10;
			number /= 10;
		}
		return res;
	}

	public static int getNumberFromDigits(int[] digits) {
		int res = 0;
		for (int i = 0; i < digits.length; i++) {
			res = res * 10 + digits[i];
		}
		return res;
	}
}
