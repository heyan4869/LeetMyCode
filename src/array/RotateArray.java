// No.189

package array;

import java.util.Arrays;

public class RotateArray {
	// double the array
	public static void rotate(int[] nums, int k) {
		int length = nums.length;
		int rk = k % length;
		int[] copy = new int[length * 2];
		for (int i = 0; i < 2 * length; i++) {
			copy[i] = nums[i % length];
		}
		for (int t = length - rk, i = 0; t < 2 * length - rk; t++, i++) {
			nums[i] = copy[t];
		}
	}

	// could only deal with positive integer
	public static void rotates(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return;
		}
		k = k % nums.length;
		if (k == 0 || k == nums.length) {
			return;
		}
		String str = Arrays.toString(nums);
		str = str.replace(" ", "").replace(",", "").replace("{", "")
				.replace("}", "").replace("[", "").replace("]", "");
		str = str.substring(nums.length - k, nums.length)
				+ str.substring(0, nums.length - k);
		char[] res = str.toCharArray();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(res[i] + "");
		}
	}

	public static void main(String[] args) {
		int[] nums = { -1, -100, 3, 99 };
		rotate(nums, 3);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(" " + nums[i] + " ");
		}
	}

}
