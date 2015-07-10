// No.198

package dp;

public class HouseRobber {
	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
        if (nums.length == 1) {
            return nums[0];
        }
		int[] dp = new int[nums.length + 1];
		dp[0] = 0;
		dp[1] = nums[0];
		for (int i = 2; i <= nums.length; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
		}
		
		return dp[nums.length];
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 1, 3, 2};
		System.out.println(rob(nums));
	}

}
