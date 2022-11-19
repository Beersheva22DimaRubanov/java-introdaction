
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
		int count = 0;
		char[] str1Arr = str1.toCharArray();
		char[] str2Arr = str2.toCharArray();
		byte[] helper = new byte[128];
		if (str1Arr.length == str2Arr.length) {
			for (int i = 0; i < str1Arr.length; i++) {
				helper[str1Arr[i]]++;
				helper[str2Arr[i]]--;
			}
			for (int i = 0; i < helper.length; i++) {
				if (helper[i] != 0)
					count++;
			}
			if (count == 0)
				res = true;
		}
		return res;
	}

	public static void sortStringNumbers(String[] array) {
		int[] helper = new int[257];
		for (int i = 0; i < array.length; i++) {
			Integer num = Integer.parseInt(array[i]);
			helper[num + 128] += 1;
		}
		int n = 0;
		for (Integer i = 0; i < helper.length; i++) {
			if (helper[i] != 0) {
				while(helper[i] != 0) {
					Integer num = i - 128;
					array[n] = num.toString();
					n++;
					helper[i] --;
				}
				
			}
		}
	}
}
