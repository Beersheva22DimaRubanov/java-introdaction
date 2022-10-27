import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
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
		return (number %100)/10;
	}

	private int getThirdDigit(int number) {
		return number % 10;
	}
	
	

}
