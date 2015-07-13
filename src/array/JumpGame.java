// No.55
// tricky

package array;

public class JumpGame {
	public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
			return true;
		int range = 0;
		int index = 0;
		while (index <= range) {
			// get the maximum range to jump
			range = Math.max(range, index + nums[index++]);
			// arrive at the last index
			if (range >= nums.length - 1) {
				return true;
			}
		}
		return false;
    }
	
	// stack overflow
	public static boolean canJumps(int[] nums) {
		if (nums == null || nums.length == 0) {
			return true;
		}
		return assist(nums, 0);
	}

	private static boolean assist(int[] nums, int cur) {
		if (cur + nums[cur] >= nums.length - 1) {
			return true;
		}
		Boolean flag = false;
		for (int i = cur + 1; i < cur + nums[cur]; i++) {
			flag = flag || assist(nums, i);
			if (flag) {
				break;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		System.out.println(canJump(nums));

	}

}
