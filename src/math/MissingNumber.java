package math;

public class MissingNumber {
	public static int missingNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res += i + 1;
			res -= nums[i];
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {0};
		System.out.println(missingNumber(nums));
	}

}
