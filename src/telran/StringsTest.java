package telran;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StringsTest {
	@Test
	void ipV40ctetTest() {
		assertTrue("123".matches(Strings.ipV40ctet()));
		assertTrue("0".matches(Strings.ipV40ctet()));
		assertTrue("255".matches(Strings.ipV40ctet()));
		assertFalse("256".matches(Strings.ipV40ctet()));
		assertTrue("089".matches(Strings.ipV40ctet()));
		assertTrue("009".matches(Strings.ipV40ctet()));
	}

	@Test
	void ipV4TestTrue() {
		assertTrue("089.045.120.230".matches(Strings.ipV4()));
		assertTrue("0.0.0.0".matches(Strings.ipV4()));
		assertTrue("123.245.213.224".matches(Strings.ipV4()));
		assertTrue("255.255.255.255".matches(Strings.ipV4()));
		assertTrue("1.4.4.6".matches(Strings.ipV4()));
	}

	@Test
	void ipV4TestFalse() {
		assertFalse("123.345.1234.123".matches(Strings.ipV4()));
		assertFalse("*.345.1234.123".matches(Strings.ipV4()));
		assertFalse("123.".matches(Strings.ipV4()));
		assertFalse("_/".matches(Strings.ipV4()));
	}

	@Test
	void computeExpressionTest() {
		assertEquals(10.5, Strings.computeArithmeticExpression("2 + 2 + 1 *2 + 0.5", null, null));
		assertTrue(Double.isNaN(Strings.computeArithmeticExpression("2 # 2 ++ 10", null, null)));
		assertEquals(10.5, Strings.computeArithmeticExpression("a + 2 +c *2 + 0.5", new double[] { 2, 3, 1, 4 },
				new String[] { "a", "b", "c", "d" }));
		assertEquals(10.5, Strings.computeArithmeticExpression("(2 + 2) + 1 *2 + 0.5", null, null));
		assertEquals(10.5, Strings.computeArithmeticExpression("((2 + 2 + 1 *2 + 0.5))", null, null));
		assertEquals(10.5, Strings.computeArithmeticExpression("(2) + (2) + (1) *(2) + (0.5)", null, null));
		assertTrue(Double.isNaN(Strings.computeArithmeticExpression("2 + 2 + 1)", null, null)));
		assertTrue(Double.isNaN(Strings.computeArithmeticExpression("2 (+ 2 + 6", null, null)));
		assertTrue(Double.isNaN(
				Strings.computeArithmeticExpression("2 + f + 2 +7", new double[] { 2, 1 }, 
						new String[] { "a", "c" })));
		assertTrue(Double.isNaN(Strings.computeArithmeticExpression("(2 + (2 + 9", null, null)));
	}
}
