import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	@Disabled
	void test() {
		int b = 10;
		short a = 20;
		char c = 'd';
		long i = (long) 10.1;
		byte d = (byte) 1000;
		a = (short) i;
		float f = 10.2f;
		int b2 =0xfffffff6;
		
		assertEquals(-10, b2);
	}
	
	@Test
	@Disabled
	void operatorsTest() {
		int a = 10;
		assertEquals(13, a+3);
		assertEquals(1, a % 3);
		int number = 400;
		assertEquals(0, getThirdDigit(number));
		assertEquals(0, getSecondDigit(number)); 
		assertEquals(4, getFirstDigit(number));
	}

	private int getFirstDigit(int number) {
		int firstDigit = number/100;
		return firstDigit;
	}

	private int getSecondDigit(int number) {
		return (number % 100)/10;
	}

	private int getThirdDigit(int number) {
		return number % 10;
	}
	
	@Test @Disabled
	void getBitValueTest() {
		long number = 0x3ab7f5; //0011 1010 1011 0111 11_1_1 0101
		assertEquals(1, BitOperations.getBitValue(number, 21));
		assertEquals(0, BitOperations.getBitValue(number, 63));
		assertEquals(0, BitOperations.getBitValue(number, 1));
		assertEquals(1, BitOperations.getBitValue(number, 2));
	}
	
	@Test @Disabled
	void setBitValueTest() {
		long number = 0x3ab7f5; //0011 1010 1011 0111 11_1_1 0101
		long number2 = 0x3ab7d5;
		assertEquals(0x1ab7f5, BitOperations.setBitValue(number, 21, false));
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number2, 5, true));
	}
	
	@Test @Disabled
	void revertBitValueTest() {
		long number = 0x3ab7f5; //0011 1010 1011 0111 11_1_1 0101
		assertEquals(0x3ab7d5, BitOperations.invertBitValue(number, 5));
		assertEquals(0x3AB7F7, BitOperations.invertBitValue(number, 1));
	}
	
	@Test @Disabled
	void minusBitValueTest() {
		long number = -1;
		assertEquals(1, BitOperations.getBitValue(number, 63));
		number = BitOperations.invertBitValue(number, 63);
		System.out.println(number);
		assertEquals(0, BitOperations.getBitValue(number, 63));
		assertEquals(-1, BitOperations.invertBitValue(number, 63));
	}
	
	@Test
	void digitsNumberTest() {
		long number = 1;
		assertEquals(1, Numbers.getNdigits(number));
	}
	
	@Test
	void leadingZeroTest() {
		long number = 0x3ab7f5;
		assertEquals(42, BitOperations.leadingZeros(number));
	}
	
	@Test
	void isHappyNumberTest() {
		int number = 203320;
		assertTrue(Numbers.isHappyNumber(number));
	}
}