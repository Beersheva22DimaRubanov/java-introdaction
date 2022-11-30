package telran.digital.numbers.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static telran.digital.numbers.DigitalNumbersPrint.*;

public class DigitalPrintingTest {
	@Test
	@Disabled
	void lineTest() {
		System.out.println(line(30, 30));
	}
	@Test
	@Disabled
	void verticalLineTest() {
		displayStrings(rightVerticalLine(30,30));
	}
	
	@Test
	@Disabled
	void twoVerticalLinesTest() {
		displayStrings(twoVerticalLines(30, 10, 5));
	}
	
	@Test
	@Disabled
	void zeroTest() {
		displayStrings(zero(5, 5, 5));
	}
	
	@Test
	@Disabled
	void oneTest() {
		displayStrings(one(5, 5, 5));
	}
	@Test
	@Disabled
	void twoTest() {
		displayStrings(nine(10, 6, 7));
		System.out.println(3/10);
	}
	
	@Test
	void displayDigitalNumberTest() {
		displayDigitalNumber(908765, 5, 5, 7);
	}
}
