package tutorials

import java.text.DecimalFormat
import java.util.Arrays;


/*
 * The following block of code allows for the initial input of values to be sorted. The number of 
 * elements must be greater than or equal to 4 in order for the code to function properly. It is 
 * advised that the number of elements not exceed 10 otherwise the code will take a long time to
 * run. 
 * 
 * After creating the sort objects, the permutation function creates all the permutations from
 * the initial input and converts it to an array. Four array objects are then created to store the
 * permutation that is being sorted as well as the number of comparisons required to sort that particular
 * permutation. 
 * 
 * Lastly, some information about the initial inputs is printed to the console, such as
 * the elements in the array of the initial input, the number of permutations of the initial input,
 * the number of elements per array, and the total number of elements the program will be working with.
 */


//.........................................INPUT VALUES BELOW.....................................
initialInput = [1,2,3,4,5,6] //Input values to sort hear. The number of elements must be >= 4
if(!(initialInput.size() >= 4)){println "ERROR! Number of Elements must be >= 4"; System.exit(0)}
//.........................................INPUT VALUES ABOVE.....................................


MergeSort merge = new MergeSort()
HeapSort heap = new HeapSort()
QuickSort quick = new QuickSort()
ShakerSort2 shaker = new ShakerSort2()
DecimalFormat df = new DecimalFormat("#0.0")


list = initialInput.permutations().toArray() 
int numOfPermutations = list.length
MergeResults[] mergeCollect = new MergeResults[numOfPermutations]
QuickResults[] quickCollect = new QuickResults[numOfPermutations]
HeapResults[] heapCollect = new HeapResults[numOfPermutations]
ShakerResults[] shakerCollect = new ShakerResults[numOfPermutations]


Integer[] forSize = list[0]
int innerArraySize = forSize.length //Need the size of the inner arrays to call quick sort method
//Integer[] t = list[0]
println "Initial Input: " + initialInput
println"Number of Permutations: " + list.size()
println "Elements per Array: " + forSize.size()
println "Total Elements: " + list.size() * forSize.size()
println ""




/*
 * The following block of code calls the sort method for each sorting algorithm on each permutation
 * of the initial input. It then stores/collects the the permutation itself and the number of comparisons 
 * required to sort the particular permutation and puts both in a Result class created for each sorting algorithm.
 * After the results are collected, the number of comparisons is reset to zero and the number of comparisons
 * is calculated for the next permutation in the list.
 */
for(int i = 0; i < numOfPermutations; i++) {	
	merge.mergeSort((Integer[])list[i])
	mergeCollect[i] = new MergeResults((Integer[])list[i], MergeSort.comparisonCount)	
	merge.resetCount()	
}

for(int i = 0; i < numOfPermutations; i++) {
	heap.heapSort((Integer[])list[i])
	heapCollect[i] = new HeapResults((Integer[])list[i], HeapSort.comparisonCount)
	heap.resetCount()	
}

for(int i = 0; i < numOfPermutations; i++) {	
	quick.quickSort((Integer[])list[i], 0, innerArraySize - 1)
	quickCollect[i] = new QuickResults((Integer[])list[i], QuickSort.comparisonCount)
	quick.resetCount()
}

for(int i = 0; i < numOfPermutations; i++) {	
	shaker.shakerSort((Integer[])list[i])
	shakerCollect[i] = new ShakerResults((Integer[])list[i], ShakerSort2.comparisonCount)
	shaker.resetCount()
}




/*
 * The following block of code prints the best 10 cases (the least number of compares required
 * to sort a permutation of the initial input) for each sorting algorithm that is being compared.
 * The corresponding unsorted array is also displayed.
 */
println "\n\tTen Best Cases"
println ".................................."
Arrays.sort(mergeCollect, new MergeTopTenComparator())
for(int i = 0; i < 10; i++) {println mergeCollect[i]}
println ""
Arrays.sort(heapCollect, new HeapTopTenComparator())
for(int i = 0; i < 10; i++) {println heapCollect[i]}
println ""
Arrays.sort(quickCollect, new QuickTopTenComparator())
for(int i = 0; i < 10; i++) {println quickCollect[i]}
println ""
Arrays.sort(shakerCollect, new ShakerTopTenComparator())
for(int i = 0; i < 10; i++) {println shakerCollect[i]}




/*
 * The following block of code prints the average number of compares for all permutations for each
 * sorting algorithm. The formula used for the calculation is the following:
 * Average = totalCompares/TotalPermutations.The average is rounded to one decimal place.
 */
String mergeAverage = df.format((double) MergeSort.getTotalCompares()/list.length)
String heapAverage = df.format((double) HeapSort.getTotalCompares()/list.length)
String quickAverage = df.format((double) QuickSort.getTotalCompares()/list.length)
String shakerAverage = df.format((double) ShakerSort2.getTotalCompares()/list.length)
println "\n\n\tAverage Compares"
println ".................................."
println "Merge:\t ${mergeAverage}"
println "Heap:\t ${heapAverage}"
println "Quick:\t ${quickAverage}"
println "Shaker:\t ${shakerAverage}"




/*
 * The following block of code prints the worst 10 cases (the most number of compares required
 * to sort a permutation of the initial input) for each sorting algorithm that is being compared.
 * The corresponding unsorted array is also displayed.
 */
println "\n\n\tTen worst Cases"
println ".................................."
Arrays.sort(mergeCollect, new MergeBottomTenComparator())
for(int i = 0; i < 10; i++) {println mergeCollect[i]}
println ""
Arrays.sort(heapCollect, new HeapBottomTenComparator())
for(int i = 0; i < 10; i++) {println heapCollect[i]}
println ""
Arrays.sort(quickCollect, new QuickBottomTenComparator())
for(int i = 0; i < 10; i++) {println quickCollect[i]}
println ""
Arrays.sort(shakerCollect, new ShakerBottomTenComparator())
for(int i = 0; i < 10; i++) {println shakerCollect[i]}




//......................................FOR TESTING......................................

/*
 * The following block of code prints the number of compares for a specific permutation
 * of the initial input, FOR ALL PERMUTATIONS, and not just the best top ten or the worst ten.
 * This block is primarily for testing purposes.
 */



/*
 
println "\nTESTING (All Compares for all Permutations)"
println ".........................................."
for(int i = 0; i < numOfPermutations; i++) {println mergeCollect[i].toString()}
println ""
for(int i = 0; i < numOfPermutations; i++) {println heapCollect[i].toString()}
println ""
for(int i = 0; i < numOfPermutations; i++) {println quickCollect[i].toString()}
println ""
for(int i = 0; i < numOfPermutations; i++) {println shakerCollect[i].toString()}

*/





