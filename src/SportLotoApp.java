
public class SportLotoApp {
	/**
	 * 
	 * Application displays out 5 random numbers from 1 to 49 inclusive
	 * numbers can not be repeated in a sequence of 6 random numbers
	 * no additional collections 
	 */
	public static void main(String[] args) {
//		System.out.print("" + 100 + " " + 200);
		for (int i = 0; i<6; i++) {
			System.out.print(getRandomInt(1, 49) + " ");
		}
	}
	
	public static int getRandomInt(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}
}