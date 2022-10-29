
/**
 * right nBit value [0, 63] all methods will return -1 in the case of wrong nBit
 * value
 * 
 *
 */
public class BitOperations {
	/**
	 * 
	 * @param number - any number
	 * @param nBit   - number of bit
	 * @return value of bit with number nBit
	 */
	static public int getBitValue(long number, int nBit) {
		int res = -1;
		if (checkNbit(nBit)) {
			long mask = 1 << nBit;
			if ((number & mask) == 0) {
				res = 0;
			} else {
				res = 1;
			}
		}
		return res;
	}

	static private boolean checkNbit(int nBit) {
		return nBit < 64 && nBit >= 0;
	}

	/**
	 * 
	 * @param number - any number
	 * @param nBit   - bit number
	 * @param value  - true for 1, false for 0
	 * @return new number in which value of nBit'h bit will have a given value
	 */
	static public long setBitValue(long number, int nBit, boolean value) {
		long res = -1;
		if (checkNbit(nBit)) {
			long mask = 0 << nBit;
			if (value) {
				res = number & ~mask;
			} else {
				mask = 1 << nBit;
				res = number & ~mask;
			}
		}
		return res;
	}

	/**
	 * 
	 * @param number - any number
	 * @param nBit   - bit number
	 * @return new number in which nBit'h will be reverted (old value - 1, new value
	 *         - 0)
	 */
	static public long revertBitValue(long number, int nBit) {
		long res = -1;
		if (checkNbit(nBit)) {
			long mask = 1 << nBit;
			if (BitOperations.getBitValue(number, nBit) == 1) {
				res = number & ~mask;
			} else if(BitOperations.getBitValue(number, nBit) == 0) {
				mask = 0 << nBit;
				res = number & ~mask;
			}
		}
		return res;
	}
}
