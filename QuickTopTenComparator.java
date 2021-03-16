package tutorials;

import java.util.Comparator;

/**
 * Represents a Comparator that sorts based on the number of comparisons
 * @author me
 *
 */
public class QuickTopTenComparator implements Comparator<QuickResults> {

	@Override
	public int compare(QuickResults o1, QuickResults o2) {
		Integer obj_1 = o1.numOfComparisons;
		Integer obj_2 = o2.numOfComparisons;
		return (obj_1.compareTo(obj_2));
		
	}

}
