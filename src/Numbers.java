
public class Numbers {
static public int getNdigits(long number) {
	int res = 0;
	do {
		number /= 10;
		res++;
	}while(number != 0);
	return res;
}

/**
 * 
 * @param number
 * @return true only if number comprise of 6 digits and sum of first 3 digits equals the sum of last 3 digits
 */
static public boolean isHappyNumber(int number) {
	int firstDigitsSum = 0;
	int lastDigitsSum = 0;
	int a = number;
	boolean flag = false;
	if (getNdigits(number) == 6) {
		for(int i = 0; i<=2; i++) {
			lastDigitsSum += a % 10;
			a /= 10;
		}
		for (int i = 0; i<=2; i++) {
			firstDigitsSum += a%10;
			a /= 10;
		}
		if (firstDigitsSum == lastDigitsSum) flag = true;
	} 
	return flag;
}
}
