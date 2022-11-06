
public class Numbers {
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
		int firstDigitsSum = 0;
		int lastDigitsSum = 0;
		boolean flag = false;

		if (getNdigits(number) == 6) {
			lastDigitsSum = getSumOfThreeDigits(number);
			firstDigitsSum = getSumOfThreeDigits(number / 1000);
		}
		flag = firstDigitsSum == lastDigitsSum;
		return flag;
	}

	static private int getSumOfThreeDigits(int number) {
		int digitsSum = 0;
		for (int i = 0; i < 3; i++) {
			digitsSum += number % 10;
			number /= 10;
		}
		return digitsSum;
	}
}
