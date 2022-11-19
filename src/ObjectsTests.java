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
	void isAnagramTest() {
		assertTrue(Strings.isAnagram("hello world", "world hello"));
		assertFalse(Strings.isAnagram("hello world", "world"));
		assertTrue(Strings.isAnagram(" ", " "));
		assertTrue(Strings.isAnagram("thing", "night"));
		String word = "yellow";
		assertTrue(Strings.isAnagram(word, "loweyl"));
		assertTrue(Strings.isAnagram(word, "elolyw"));
		assertTrue(Strings.isAnagram(word, "wolley"));
		assertTrue(Strings.isAnagram(word, "loleyw"));
		assertFalse(Strings.isAnagram(word, ""));
		assertFalse(Strings.isAnagram(word, "yellob"));
		assertFalse(Strings.isAnagram(word, "yello"));
		assertFalse(Strings.isAnagram(word, "yelllo"));
	}

	@Test
	void sortStringNumbersTest() {
		String[] arr1 = { "-128", "2", "-4", "54", "128", "-76", "123" };
		String[] sortedArr1 = { "-128", "-76", "-4", "2", "54", "123", "128" };
		String[] arr2 = { "5", "-37", "15", "2", "22", "120", "118", "-110", "5", "2", "1", "0", "127", "-128", "1", "5" };
		String[] sortedArr2 = { "-128", "-110", "-37", "0", "1", "1", "2", "2", "5", "5", "5", "15", "22", "118", "120", "127" };
		Strings.sortStringNumbers(arr2);
		Strings.sortStringNumbers(arr1);
		assertArrayEquals(sortedArr1, arr1);
		assertArrayEquals(sortedArr2, arr2);
	}
}
