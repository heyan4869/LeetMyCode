// No.1

package hash;

import java.util.*;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (!hm.containsKey(nums[i])) {
				hm.put(target - nums[i], i);
			} else {
				res[0] = hm.get(nums[i]) + 1;
				res[1] = i + 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int[] res = twoSum(nums, 18);
		System.out.print(res[0] + " " + res[1]);
	}

}
