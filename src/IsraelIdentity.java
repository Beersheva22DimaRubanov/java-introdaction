
public class IsraelIdentity {
	public static final int N_DIGITS_ID = 9;

	/**
	 * 
	 * @param id
	 * @return true for right id otherwise false number control sum should be
	 *         multiple of 10 (sum % 10 = 0) for even indexes (0, 2, 4, 6, 8) digits
	 *         as is for odd indexes (1, 3, 5, 7, 9) digit = digit * 2, if>9 the sum
	 *         of inner digits is taken example 123456782 = 1 + 4(2*2) + 3 + 8(4*2)
	 *         + 5 + 3(6 * 2 => 1+2) + 7 + 7(8 * 2 =16 => 1+7)
	 */
	public static boolean verifyId(int id) {
		boolean res = false;
		if (id > 0) {
			int digits[] = Numbers.getDigits(id);
			if (digits.length == N_DIGITS_ID) {
				res = getControlSum(digits) % 10 == 0;
			}
		}
		return res;
	}

	/**
	 * 
	 * @return random number of 9 digits matching right Israel id cycle not more
	 *         than 9 iteration 0 can be but not the first number
	 */
	public static int generateRandomId() {
		int digits[] = new int[N_DIGITS_ID - 1];
		fillRandomDigits(digits);
		int controlSum = getControlSum(digits);
		int lastDigit = getLastDigit(controlSum);
		int res = Numbers.getNumberFromDigits(digits);
		res = res * 10 + lastDigit;
		return res;
	}

	private static int getLastDigit(int controlSum) {
		int rem = controlSum%10;
		int res = 0;
		if(rem != 0) {
			res = 10-rem;
		}
		return res;
	}

	private static void fillRandomDigits(int[] digits) {
		digits[0] = SportLotoApp.getRandomInt(1, 9);
		for (int i = 1; i < digits.length; i++) {
			digits[i] = SportLotoApp.getRandomInt(0, 9);
		}
	}

	private static int getControlSum(int[] digits) {
		return sumEvenIndexes(digits) + sumOddIndexes(digits);
	}

	private static int sumOddIndexes(int[] digits) {
		int res = 0;
		for (int i = 1; i < digits.length; i = i + 2) {
			int oddDigit = digits[i] * 2;
			if (oddDigit > 9) {
				oddDigit -= 9;
			}
			res += oddDigit;
		}
		return res;

	}

	private static int sumEvenIndexes(int[] digits) {
		int res = 0;
		for (int i = 0; i < digits.length; i = i + 2) {
			res += digits[i];
		}
		return res;
	}
}
