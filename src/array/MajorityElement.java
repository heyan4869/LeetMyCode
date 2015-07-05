package array;

import java.util.Arrays;

public class MajorityElement {
	public static int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
