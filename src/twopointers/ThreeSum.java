// No.15

package twopointers;

import java.util.*;

public class ThreeSum {
	// this got TLE
	// solved by skipping the duplicate elements
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length < 3) {
			return res;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int start = i + 1;
				int end = nums.length - 1;
				while (start < end) {
					int cur = nums[i] + nums[start] + nums[end];
					if (cur == 0) {
						List<Integer> temp = new ArrayList<Integer>();
						temp.add(nums[i]);
						temp.add(nums[start]);
						temp.add(nums[end]);
						if (!res.contains(temp)) {
							res.add(temp);
						}
						while (start < end && nums[start] == nums[start + 1]) {
							start++;
						}
						while (start < end && nums[end] == nums[end - 1]) {
							end--;
						}
						start++;
						end--;
					} else if (cur > 0) {
						end--;
					} else {
						start++;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> res = threeSum(nums);
		for (int i = 0; i < res.size(); i++) {
			List<Integer> temp = res.get(i);
			for (int j = 0; j < temp.size(); j++) {
				System.out.print(" " + temp.get(j) + " ");
			}
			System.out.println();
		}
	}

}
