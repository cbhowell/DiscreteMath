package tutorials;

import java.util.Arrays;

/**
 * Represents a class that stores the permutation of the array to be sorted, as well as
 * the number of comparisons required to sort that array.
 * @author me
 *
 */
public class HeapResults {

	Integer[] arrayToSort;
	Integer numOfComparisons;

	HeapResults(Integer[] a, Integer num) {
		this.arrayToSort = a;
		this.numOfComparisons = num;
		toString();
	}

	@Override
	public String toString() {
		return "Heap: " + Arrays.toString(arrayToSort) + " Compares: " + numOfComparisons;
	}
}
