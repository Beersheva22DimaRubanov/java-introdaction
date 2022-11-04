
public class SportLotoApp {
	/**
	 * 
	 * Application displays out 5 random numbers from 1 to 49 inclusive
	 * numbers can not be repeated in a sequence of 6 random numbers
	 * no additional collections 
	 */
	public static void main(String[] args) {
//		System.out.print("" + 100 + " " + 200);
		int firstDigit = getRandomInt(1, 49);
		int secondDigit = getRandomInt(1, 49);
		int thirdDigit = getRandomInt(1, 49);
		int fourthDigit = getRandomInt(1, 49);
		int fifthDigit = getRandomInt(1, 49);
		int sixthDigit = getRandomInt(1, 49);
		while(firstDigit == secondDigit || firstDigit == thirdDigit || firstDigit == fourthDigit || firstDigit == fifthDigit
				|| firstDigit == sixthDigit) {
			firstDigit = getRandomInt(1, 49);
		}
		while (secondDigit == thirdDigit || secondDigit == fourthDigit || secondDigit == fifthDigit || secondDigit == sixthDigit
				|| secondDigit == firstDigit) {
			secondDigit = getRandomInt(1, 49);
		}
		while (thirdDigit == fourthDigit || thirdDigit == fifthDigit || thirdDigit == sixthDigit || thirdDigit == firstDigit
				|| thirdDigit == secondDigit) {
			thirdDigit = getRandomInt(1, 49);
		}
		while(fourthDigit == fifthDigit || fourthDigit == sixthDigit || fourthDigit == firstDigit || fourthDigit == secondDigit
				|| fourthDigit == thirdDigit) {
			fourthDigit = getRandomInt(1, 49);
		}
		while (fifthDigit == sixthDigit || fifthDigit == firstDigit || fifthDigit == secondDigit || fifthDigit == thirdDigit 
				|| fifthDigit == fourthDigit) {
			fifthDigit = getRandomInt(1, 49);
		}
		while (sixthDigit == firstDigit || sixthDigit == secondDigit || sixthDigit == thirdDigit || sixthDigit == fourthDigit
				|| sixthDigit == fifthDigit) {
			sixthDigit = getRandomInt(1, 49);
		}
		System.out.println(firstDigit + " " + secondDigit + " " + thirdDigit + " " + fourthDigit + " " + fifthDigit + " " + sixthDigit);
//		for (int i = 0; i<6; i++) {
//			System.out.print(getRandomInt(1, 49) + " ");
//		}
	}
	
	public static int getRandomInt(int min, int max) {
		
		return (int) (min + Math.random() * (max - min + 1));
	}
}

//1==2 || 1 == 3 || 1 == 4 || 1 == 5 