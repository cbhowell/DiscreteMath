package tutorials;

import java.util.Arrays;


/**
 * Represents a class that stores the permutation of the array to be sorted, as well as
 * the number of comparisons required to sort that array.
 * @author me
 *
 */
public class MergeResults {
	
	Integer[] arrayToSort;
	Integer numOfComparisons;

	MergeResults(Integer[] a, Integer num) {
		this.arrayToSort = a;
		this.numOfComparisons = num;
		toString();
		//System.out.println("Created: " + this.arrayToSort + " Comparisons: " + this.numOfComparisons);
	}

	@Override
	public String toString() {
		return "Merge: " + Arrays.toString(arrayToSort) + " Compares: " + numOfComparisons;
	}
	
	

}
