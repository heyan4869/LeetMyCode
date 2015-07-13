// No.16

package twopointers;

import java.util.Arrays;

public class ThreeSumClosest {
	public static int threeSumClosest(int[] nums, int target) {
		int res = 0;
		if (nums.length <= 3) {
			for (int i : nums) {
				res += i;
			}
			return res;
		}
		res = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			int start = i + 1, end = nums.length - 1;
			while (start < end) {
				int currsum = nums[i] + nums[start] + nums[end];
				if (currsum > target) {
					end--;
				} else {
					start++;
				}
				if (Math.abs(currsum - target) < Math.abs(res - target)) {
					res = currsum;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {0, 2, 1, -3};
		System.out.println(threeSumClosest(nums, 1));
	}

}
