package tutorials;

import java.util.Comparator;


public class HeapTopTenComparator implements Comparator<HeapResults> {

	@Override
	public int compare(HeapResults o1, HeapResults o2) {
		Integer obj_1 = o1.numOfComparisons;
		Integer obj_2 = o2.numOfComparisons;
		return (obj_1.compareTo(obj_2));
	}

}
