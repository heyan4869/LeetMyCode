// No.135

package array;

import java.util.Arrays;

public class Candy {
	public static int candy(int[] ratings) {
		int[] nums = new int[ratings.length];
		Arrays.fill(nums, 1);
		int count = ratings.length;
		// forward
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				int diff = nums[i - 1] + 1 - nums[i];
				nums[i] += diff;
				count += diff;
			}
		}

		// backforward
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				if (i - 1 >= 0 && ratings[i - 1] <= ratings[i]) {
					int temp = nums[i];
					nums[i] = Math.max(nums[i + 1] + 1, nums[i]);
					count += (nums[i] - temp);
				} else {
					int diff = nums[i + 1] + 1 - nums[i];
					nums[i] += diff;
					count += diff;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] ratings = { 4, 2, 3, 4, 1 };
		System.out.println(candy(ratings));
	}
}
