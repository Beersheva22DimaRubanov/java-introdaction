import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ObjectsTests {

	@Test
	void wrapperTest() {
		Integer a = 11;
		Integer b = 11;
		assertEquals(a, b);
		Integer c = 201;
		Integer d = 201;
		assertEquals(c, d);
		assertTrue(a == b);
		assertFalse(c == d);
		assertTrue(c.equals(d));
	}

	@Test
	void stringTest() {
		String hello = "hello";
		char[] helloAr = hello.toCharArray();
		assertEquals('h', helloAr[0]);
		System.out.println((byte) helloAr[2]);

	}
	
	@Test
	void isAnagramTest(){
		assertTrue(Strings.isAnagram("hello world", "world hello"));
		assertFalse(Strings.isAnagram("hello world", "world"));
		assertTrue(Strings.isAnagram(" ", " "));
		assertTrue(Strings.isAnagram("thing", "night"));
	}
}
