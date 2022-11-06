import java.util.PrimitiveIterator.OfLong;

/**
 * right nBit value [0, 63] all methods will return -1 in the case of wrong nBit
 * value
 * 
 *
 */
public class BitOperations {
	private static final int N_BITS = 64;

	/**
	 * 
	 * @param number - any number
	 * @param nBit   - number of bit
	 * @return value of bit with number nBit
	 */
	static public int getBitValue(long number, int nBit) {
		int res = -1;
		if (checkNbit(nBit)) {
			long mask = BitOperations.getMask(nBit);
			res = (number & mask) == 0 ? 0 : 1;
		}
		return res;
	}

	static private long getMask(int nBit) {
		return (long) 1 << nBit;
	}

	static private boolean checkNbit(int nBit) {
		return nBit < N_BITS && nBit >= 0;
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
			res = value ? number | mask : number & ~mask;
//			if (value) {
//				res = number | mask;
//			} else {
//				res = number & ~mask;
//			}
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
	static public long invertBitValue(long number, int nBit) {
		long res = -1;
		if (checkNbit(nBit)) {
			long mask = getMask(nBit);
			res = number ^ mask;
//			if (BitOperations.getBitValue(number, nBit) == 1) {
//				res = number & ~mask;
//			} else                                                                                                              {
//				res = number | mask;
//			}
		}
		return res;
	}

	static public int leadingZeros(long number) {
		int res = 0;
		int nBit = N_BITS - 1;
		while (nBit >= 0 && getBitValue(number, nBit) == 0) {
			nBit--;
			res++;
		}
		return res;
	}

	static public int oneInNumber(long number) {
		int res = 0;
		for (int i = 0; i < N_BITS; i++) {
			if (getBitValue(number, i) == 1) {
				res++;
			}
		}
		return res;
	}
}
