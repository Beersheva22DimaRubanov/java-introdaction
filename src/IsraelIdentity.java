
public class IsraelIdentity {
	/**
	 * 
	 * @param id
	 * @return true for right id otherwise false
	 * number 
	 * control sum should be multiple of 10 (sum % 10 = 0)
	 * for even indexes (0, 2, 4, 6, 8) digits as is
	 * for odd indexes (1, 3, 5, 7, 9) digit = digit * 2, if>9 the sum of inner digits is taken
	 * example 123456782 = 1 + 4(2*2) + 3 + 8(4*2) + 5 + 3(6 * 2 => 1+2) + 7 + 7(8 * 2 =16 => 1+7)
	 */
	public static boolean verify(int id) {
//		TODO
		return false;
	}
	
	/**
	 * 
	 * @return random number of 9 digits matching right Israel id
	 * cycle not more than 9 iteration
	 * 0 can be but not the first number                 
	 */
	public static int generateRandomId() {
		int res =0;
		for(int i = 0; i < 8; i++) {
			if(i == 0) {
				res = res*10 + SportLotoApp.getRandomInt(1, 9);
			}
			res = res*10 + SportLotoApp.getRandomInt(0, 9);
		}
		
		return 0;
	}
	
}
