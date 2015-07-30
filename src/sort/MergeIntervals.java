// No.56

package sort;

import java.util.*;

public class MergeIntervals {
	public static List<Interval> merge(List<Interval> intervals) {
		// use customized comparator
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval obj0, Interval obj1) {
				return obj0.start - obj1.start;
			}
		});

		// merge the intervals
		List<Interval> res = new ArrayList<Interval>();
		Interval prev = null;
		for (Interval inter : intervals) {
			if (prev == null || inter.start > prev.end) {
				res.add(inter);
				prev = inter;
			} else if (inter.end > prev.end) {
				// modify the element already in list
				prev.end = inter.end;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
