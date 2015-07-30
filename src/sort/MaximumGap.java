// No.164
// confused
// bucket sort, take O(n)

package sort;

import java.util.*;

public class MaximumGap {
	public static int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		List<Integer> sorted = new ArrayList<Integer>(nums.length);
		for (int e : nums) {
			sorted.add(e);
		}

		// 2 buckets
		List<Integer> bucket0 = new ArrayList<Integer>();
		List<Integer> bucket1 = new ArrayList<Integer>();

		int mask = 1;
		// 31 iterations
		while (mask > 0) {
			for (int i = 0; i < nums.length; i++) {
				int n = sorted.get(i);
				if ((n & mask) == 0) {
					bucket0.add(n);
				} else {
					bucket1.add(n);
				}
			}
			sorted.clear();
			sorted.addAll(bucket0);
			sorted.addAll(bucket1);
			bucket0.clear();
			bucket1.clear();
			mask <<= 1;
		}

		int maxDiff = 0;
		for (int i = 1; i < nums.length; i++) {
			int n = sorted.get(i) - sorted.get(i - 1);
			if (n > maxDiff)
				maxDiff = n;
		}
		return maxDiff;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
