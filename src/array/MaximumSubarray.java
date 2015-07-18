// No.53
// Find the contiguous subarray within an array 
// (containing at least one number) which has the largest sum.

package array;

public class MaximumSubarray {
	public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int sum = nums[0];
		int res = nums[0];

		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(sum + nums[i], nums[i]);
			res = Math.max(res, sum);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(nums));
	}
}
