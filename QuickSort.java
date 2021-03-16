package tutorials;

import java.util.Arrays;
import java.util.Random;

/**
 * Represents a class that calculates the number of comparisons used by the QuickSort algorithm. It is said by the Internet that the worst-case
 * comparison count can be given by the following formula: [n(n-1)]/2, where n is the number of elements in the array. For example, if n = 3,
 * then we can expect a worst-case comparison of [3(2)]/2 = 3. The expected results were observed while running the following experiment: After
 * running the program 4000 times with a three element randomly generated array, there were zero occurrences whereby the comparison count
 * exceeded the expected value of 3. Based on this experiment, I will consider the comparison count implementation to be accurate and the
 * QuickSort implementation to be correct. The worst-case time complexity for Quick Sort is O(0.5N^2), but in practice it provides a
 * probabilistic guarantee of O(nLogn). This means we can expect Quick Sort to perform worse than Merge Sort but better than Heap Sort or
 * Shaker Sort. These results were observed during experimentation.
 * 
 * Code Reference: https://www.programcreek.com/2012/11/quicksort-array-in-java/
 * 
 * @author me
 *
 *         I am confident this code works properly
 */
@SuppressWarnings("unused")
public class QuickSort {
	static int comparisonCount = 0;
	static int totalComparisons = 0;

	/*
	 * Test client to ensure the worst case comparison does not exceed three given three elements in the array. The test client will run for
	 * 4000 trials.
	 */
	public static void main(String[] args) {
		Random randNum = new Random();
		int numOfTrials = 4000;
		int numElements = 4;
		int overThree = 0;
		int count = 0;

		Integer[] a = new Integer[numElements];

		while (count < numOfTrials) {
			for (int i = 0; i < numElements; i++) {
				a[i] = randNum.nextInt(10);
			} //
			System.out.println("Initial: " + Arrays.toString(a));
			quickSort(a, 0, a.length - 1); // System.out.println(Arrays.toString(a));
			System.out.println("Quick Sort Comparison: " + QuickSort.comparisonCount);
			if (QuickSort.comparisonCount == 6) {
				overThree++;
			}
			resetCount();
			count++;
		}
		System.out.println("Over Three Count: " + overThree);

	}

	/**
	 * Resets the comparison count to zero. This is used for testing purposes so the client can run the QuickSort algorithm multiple times via
	 * a while loop to ensure the comparison count does not exceed the expected worst-case value.
	 */
	public static void resetCount() {
		comparisonCount = 0;
	}

	/**
	 * This method returns the total number of comparisons made by QuickkSort, which will depend on the number of times the sort method is
	 * called by the client. This method should be used to calculate the average number of compares.
	 * 
	 * @return the total number of compares
	 */
	public static int getTotalCompares() {
		return totalComparisons;
	}

	public static void quickSort(Integer[] arr, int start, int end) {

		int partition = partition(arr, start, end);

		if (partition - 1 > start) {
			quickSort(arr, start, partition - 1);
		}
		if (partition + 1 < end) {
			quickSort(arr, partition + 1, end);
		}
	}

	public static int partition(Integer[] arr, int start, int end) {
		int pivot = arr[end];

		for (int i = start; i < end; i++) {
			// comparisonCount++;
			// totalComparisons++;
			if (arr[i] < pivot) {
				comparisonCount++;
				totalComparisons++;
				int temp = arr[start];
				arr[start] = arr[i];
				arr[i] = temp;
				start++;
			}
		}

		int temp = arr[start];
		arr[start] = pivot;
		arr[end] = temp;

		return start;
	}
}