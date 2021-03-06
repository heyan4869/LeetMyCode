// No.57

package sort;

import java.util.*;

public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		for (Interval i : intervals) {
			if (newInterval == null || i.end < newInterval.start)
				result.add(i);
			else if (i.start > newInterval.end) {
				result.add(newInterval);
				result.add(i);
				newInterval = null;
			} else {
				newInterval.start = Math.min(newInterval.start, i.start);
				newInterval.end = Math.max(newInterval.end, i.end);
			}
		}
		if (newInterval != null)
			result.add(newInterval);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
