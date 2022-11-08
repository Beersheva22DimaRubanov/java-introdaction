
public class SportLotoApp {
	/**
	 * 
	 * Application displays out 5 random numbers from 1 to 49 inclusive numbers can
	 * not be repeated in a sequence of 6 random numbers no additional collections
	 */
	public static void main(String[] args) {
		long numForCheck = (long) 0;
		for (int i = 0; i < 6; i++) {
			int number = getRandomInt(1, 49);
			while (BitOperations.getBitValue(numForCheck, number) == 1) {
				number = getRandomInt(1, 49);
			}
			numForCheck = BitOperations.setBitValue(numForCheck, number, true);
			System.out.print(number + " ");
		}
	}

	public static int getRandomInt(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}
}
