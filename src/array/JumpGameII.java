// No.45
// tricky

package array;

public class JumpGameII {
	public static int jump(int[] nums) {
		int stepCount = 0;
		int lastJumpMax = 0;
		int currJumpMax = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			currJumpMax = Math.max(currJumpMax, i + nums[i]);
			if (i == lastJumpMax) {
				stepCount++;
				lastJumpMax = currJumpMax;
			}
		}
		return stepCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
