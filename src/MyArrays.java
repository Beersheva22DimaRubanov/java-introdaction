import java.util.Arrays;

public class MyArrays {
	/**
	 * 
	 * @param aray
	 * @param number
	 * @return new array with added at end a given number
	 */
	public static int[] addsNumber(int[] array, int number) {
		int[] newArray = Arrays.copyOf(array, array.length + 1);
		newArray[newArray.length - 1] = number;
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param index
	 * @return new array with no number at a given index in a given array if index
	 *         doesn't exist in a given array it returns the dame array
	 */
	public static int[] removeNumber(int array[], int index) {
		int res[] = array;
		if (index >= 0 && index < array.length) {
			res = new int[array.length - 1];
			System.arraycopy(array, 0, res, 0, index);
			System.arraycopy(array, index + 1, res, index, res.length - index);
		}
		return res;
	}

	/**
	 * 
	 * @param arraySorted - sorted array
	 * @param number
	 * @return new array with inserted number at an index for keeping array sorted
	 */
	public static int[] insertSorted(int arraySorted[], int number) {
		int numberIndex = Arrays.binarySearch(arraySorted, number);
		if (numberIndex < 0) {
			numberIndex = -(numberIndex + 1);
		}
		return insrertAtIndex(arraySorted, number, numberIndex);
	}

	private static int[] insrertAtIndex(int[] array, int number, int numberIndex) {
		int[] res = new int[array.length + 1];
		System.arraycopy(array, 0, res, 0, numberIndex);
		if (numberIndex < res.length - 1) {
			System.arraycopy(array, numberIndex, res, numberIndex + 1, (res.length - numberIndex) - 1);
			res[numberIndex] = number;
		}
		res[numberIndex] = number;
		return res;
	}

	/**
	 * 
	 * @param arraySorted
	 * @param number
	 * @return index value if number exists otherwise -1 O[N] - search number in
	 *         unsorted array O[logN] - search number in sorted (binary search)
	 */
	public static int binarySearch(int[] arraySorted, int number) {
//		int left = 0;
//		int right = arraySorted.length - 1;
//		int middle = arraySorted.length / 2;
//		int result = -1;
//		boolean flag = false;
//		while (left <= right) {
//			if (number < arraySorted[middle]) {
//				right = middle - 1;
//			}
//			if (number > arraySorted[middle]) {
//				left = middle + 1;
//			}
//			if (number == arraySorted[middle]) {
//				flag = true;
//				result = middle;
//				right = middle - 1;
//			}
//			middle = (left + right) / 2;
//		}
//		return !flag ? -(left + 1) : result;
		int  left = 0;
		int right = arraySorted.length - 1;
		int middle = arraySorted.length / 2;
		while(left <= right && arraySorted[left] != number) {
			if (number <= arraySorted[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right) / 2;
		}
		return  left < arraySorted.length && arraySorted[left] == number ? left : -left - 1;
	}
	
	

	public static int[] bubleSort(int[] array) {
		int unsortedLength = array.length;
		do {
			unsortedLength = moveGreaterRight(array, unsortedLength-1);
		} while(unsortedLength != 0);
		return array;
	}

	private static int moveGreaterRight(int array[], int length) {
		int res = 0;
		for(int i =0; i<length; i++){
			if (array[i] > array[i+1]) {
				res = i+1;
				swap(array, i, i+1);
			}
		}
		return res;
	}

	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[i+1];
		array[j] = tmp;
	}

	public static boolean isOneSwapForSorted(int[] array) {
//		int count = 0;
//		boolean res = false;
//		int firstIndex = -1;
//		int secondIndex = 0;
//		for (int i = 0; i < array.length - 1; i++) {
//			if (array[i] > array[i + 1]) {
//				count++;
//				if (firstIndex < 0) {
//					firstIndex = i;
//				}
//				if (count == 2) {
//					secondIndex = i + 1;
//				}
//			}
//		}
//		if (count == 2) {
//			int temp;
//			temp = array[firstIndex];
//			array[firstIndex] = array[secondIndex];
//			array[secondIndex] = temp;
//			if (firstIndex == 0 && secondIndex < array.length - 2) {
//				if (array[firstIndex] < array[firstIndex + 1] && array[secondIndex] > array[secondIndex - 1]
//						&& array[secondIndex] < array[secondIndex + 1]) {
//					res = true;
//				}
//			} else if (firstIndex == 0 && secondIndex == array.length - 1) {
//				if (array[firstIndex] < array[firstIndex + 1] && array[secondIndex] > array[secondIndex - 1]) {
//					res = true;
//				}
//			} else if (firstIndex > 0 && secondIndex == array.length - 1) {
//				if (array[firstIndex] < array[firstIndex + 1] && array[firstIndex] > array[firstIndex - 1]
//						&& array[secondIndex] > array[secondIndex - 1]) {
//					res = true;
//				}
//			} else if (firstIndex > 0 && secondIndex <= array.length - 2) {
//				if (array[firstIndex] < array[firstIndex + 1] && array[firstIndex] > array[firstIndex - 1]
//						&& array[secondIndex] > array[secondIndex - 1] && array[secondIndex] < array[secondIndex + 1]) {
//					res = true;
//				}
//			}
//		}
//		if (count == 1) {
//			int temp;
//			temp = array[firstIndex];
//			array[firstIndex] = array[firstIndex + 1];
//			array[firstIndex + 1] = temp;
//			if (firstIndex > 0 && firstIndex < array.length - 2) {
//				if (array[firstIndex] > array[firstIndex - 1] && array[firstIndex + 1] < array[firstIndex + 2]) {
//					res = true;
//				}
//			} else if (firstIndex == 0) {
//				if (array[firstIndex + 1] < array[firstIndex + 2]) {
//					res = true;
//				}
//			} else if (firstIndex == array.length - 2) {
//				if (array[firstIndex] > array[firstIndex - 1]) {
//					res = true;
//				}
//			}
//		}
//		return res;


		int index1 = -1;
		int index2 = -1;
		int length = array.length - 1;
		int equaledCount = 0;
		boolean res = true;
		int i = 0;
		while (i < length && res) {
			if (array[i] > array[i + 1]) {
				if (index1 == -1) {
					index1 = i - equaledCount;
					if (equaledCount > 0) {
						index2 = i + 1;
					}
				} else if (index2 != -1) {
					res = false;
				} else {
					index2 = i + 1;
				}
			} else if (array[i] == array[i + 1]) {
				equaledCount++;
			} else if (array[i] < array[i + 1]) {
				if (equaledCount != 0 && index1 != -1 && index2 == -1 && array[i] < array[index1]) {
					index2 = i;
				}
				equaledCount = 0;
			}
			i++;
		}
		return index1 != -1 && res ? checkIndexes(array, index1, index2) : false;
	}
	
	private static boolean checkIndexes(int[] array, int index1, int index2) {

		return index2 == -1 ? checkOneIndex(array, index1) : checkTwoIndexes(array, index1, index2);
	}

	private static boolean checkTwoIndexes(int[] array, int index1, int index2) {

		return (index2 == array.length - 1 || array[index1] <= array[index2 + 1]) 
				&& array[index2] <= array[index1 + 1]
				&& (index1 == 0 || array[index2] >= array[index1 - 1]);
		
	}

	private static boolean checkOneIndex(int[] array, int index) {

		return (index == array.length - 2 || array[index] <= array[index + 2])
				&& (index == 0 || array[index + 1] >= array[index - 1]);
	}

	/**
	 * 
	 * @param array of short positive numbers                
	 * @param sum
	 * @return true if array contains two numbers sum of which equals a given sum
	 */
	static public boolean isSum2(short array[], short sum) {
		boolean res = false;
		return false;
	}
}
