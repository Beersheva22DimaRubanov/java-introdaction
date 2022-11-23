
public class Strings {
	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return true if str2 is an anagram of str1 O(n) 1. the same length 2. the
	 *         same symbols just in different order
	 */
	public static boolean isAnagram(String str1, String str2) {
		boolean res = false;
		if (str1.length() == str2.length()) {
			res = true;
			byte[] helper = new byte[Byte.MAX_VALUE];
			fillHelper(helper, str1);
			int index = 0;
			int length = str1.length();
			while (index < length && res) {
				int indSymb = (int) str2.charAt(index);
				if (helper[indSymb] == 0) {
					res = false;
				} else {
					index++;
					helper[indSymb]--;
				}
			}
		}
		return res;
	}

	private static void fillHelper(byte[] helper, String str1) {
		int length = str1.length();
		for (int i = 0; i < length; i++) {
			int ind = str1.charAt(i);
			helper[ind]++;
		}
	}

	public static void sortStringNumbers(String[] array) {
		int offset = Byte.MAX_VALUE + 1;
		int[] helper = new int[offset * 2];
		fillHelper(helper, array, offset);
		sortFromHelper(array, helper, offset);

	}

	private static void sortFromHelper(String[] array, int[] helper, int offset) {
		int arrayInd = 0;
		for (int i = 0; i < helper.length; i++) {
			for (int j = 0; j < helper[i]; j++) {
				array[arrayInd++] = getStringNumberFromIndex(i, offset);
			}
		}

	}

	private static String getStringNumberFromIndex(int index, int offset) {
		int number = index - offset;
		return Integer.toString(number);
	}

	private static void fillHelper(int[] helper, String[] array, int offset) {
		for (int i = 0; i < array.length; i++) {
			int index = getIndexFromStringNumber(array[i], offset);
			helper[index]++;
		}
	}

	private static int getIndexFromStringNumber(String string, int offset) {
		int number = Integer.parseInt(string);
		return number + offset;
	}
	
	public static String javaNameExp() {
		
		return "[a-zA-Z$][\\w$]*|_[\\w$]+";
	}
	
	public static String ipV40ctet() {
		return "(2([0-4][0-9]|5[0-5])|[0-1]\\d\\d|[0-9]{1,2})";
	}
	
	public static String ipV4() {
		return "((2([0-4][0-9]|5[0-5])|[0-1]\\d\\d|[0-9]{1,2})\\.){3}(2([0-4][0-9]|5[0-5])|[0-1]\\d\\d|[0-9]{1,2})";
	}
}
