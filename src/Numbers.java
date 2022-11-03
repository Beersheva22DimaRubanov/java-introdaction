
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
	//TODO
	return false;
}
}
