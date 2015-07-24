// No.137

package bit;

import java.util.*;

public class SingleNumberII {
	public static int singleNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MAX_VALUE;
		}
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!hm.containsKey(nums[i])) {
				res = res ^ nums[i];
				hm.put(nums[i], 1);
			} else {
				res = res ^ nums[i];
				int count = hm.get(nums[i]);
				hm.put(nums[i], count + 1);
				// if appears three times, ^ one more time
				if (count + 1 == 3) {
					res = res ^ nums[i];
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 1, 3, 1, 3, 2 ,4, 3, 2};
		System.out.println(singleNumber(nums));
	}

}
