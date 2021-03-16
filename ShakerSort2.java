package tutorials;

import java.util.Arrays;

/**
 * Represents a class that calculates the number of comparisons that Shaker Sort uses to completely sort an array. The worst case number of
 * comparisons is given by the formula, { n(n - 1)/2}, where n is the number of elements in the array. For example, if we have 3 elements in
 * the array, then we should expect a worse case of 3 comparisons if all the elements are out of order. These results were observed during
 * experimentation, thus, I will consider this the correct implementation of Shaker Sort and the number of comparisons are being calculated
 * correctly. Shaker Sort has a worst-case time complexity of O(N^2), thus, we should expect it to be the worst performing algorithm out Merge
 * Sort, Quick Sort or Heap Sort. These results were observed during experimentation.
 * 
 * Reference: https://www.cise.ufl.edu/~sahni/dsaaj/enrich/c2/shaker.htm
 * 
 * @author me
 *
 * This code functions properly.
 */
public class ShakerSort2 {

	static int comparisonCount = 0;
	static int totalComparisons = 0;
	private static int temp;

	/**
	 * sort the elements a[0 : a.length - 1] using the shaker sort method
	 */
	public static void shakerSort(Comparable<Integer>[] a) {
		for (int p = 1; p <= a.length / 2; p++) {
			
			
			// first do left to right bubbling pass
			for (int i = p - 1; i < a.length - p; i++) {
				comparisonCount++;
				totalComparisons++;
				if (a[i].compareTo((Integer) a[i + 1]) > 0) {
					//comparisonCount++;
					//totalComparisons++;
					swapLeftToRight(a, i);
					//System.out.println(Arrays.toString(a));
					
				} // end if statement
			} // end inner for loop
				// now do right to left bubbling pass
			for (int i = a.length - p - 1; i >= p; i--) {
				comparisonCount++;
				totalComparisons++;
				if (a[i].compareTo((Integer) a[i - 1]) < 0) {
					//comparisonCount++;
					//totalComparisons++;
					swapRightToLeft(a, i);	
					//System.out.println(Arrays.toString(a));
				} // end if
			} // end inner for loop
		} // end outer for loop
	}// end method

	/**
	 * @param a
	 * @param i
	 */
	public static void swapRightToLeft(Comparable<Integer>[] a, int i) {
		temp = (int) a[i];
		a[i] = a[i - 1];
		a[i - 1] = temp;
	}

	/**
	 * @param a
	 * @param i
	 */
	public static void swapLeftToRight(Comparable<Integer>[] a, int i) {
		temp = (int) a[i];
		a[i] = a[i + 1];
		a[i + 1] = temp;
	}

	public static int getCountComparison() {
		return comparisonCount;
	}

	/**
	 * Resets the comparison count to zero. This is used for testing purposes so the client can run the QuickSort algorithm multiple times via
	 * a while loop to ensure the comparison count does not exceed the expected worst-case value.
	 */
	public static void resetCount() {
		comparisonCount = 0;
	}

	/**
	 * This method returns the total number of comparisons made by ShakerSort, which will depend on the number of times the sort method is
	 * called by the client. This method should be used to calculate the average number of compares.
	 * 
	 * @return the total number of compares
	 */
	public static int getTotalCompares() {
		return totalComparisons;
	}

	public static void main(String[] args) {

		Integer[] a = {2,3,4,5,1};
		System.out.println("Initial Input"+Arrays.toString(a));
		shakerSort(a);
		System.out.println("Sorted: " + Arrays.toString(a));
		System.out.println("Comparisons: " + ShakerSort2.comparisonCount);

	}

}
