import java.util.PrimitiveIterator.OfLong;

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
			if ((number & getMask(nBit)) == 0) {
				res = 0;
			} else {
				res = 1;
			}
		}
		return res;
	}
	
	static private long getMask(int nBit) {
		long mask =  (long) 1 << nBit; 
		return mask;
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
			long mask = getMask(nBit);
			if (value) {
				res = number | mask;
			} else {
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
			long mask = getMask(nBit);
			if (BitOperations.getBitValue(number, nBit) == 1) {
				res = number & ~mask;
			} else                                                                                                              {
				res = number | mask;
			}
		}
		return res;
	}
}
