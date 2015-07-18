// No.18

package hash;

import java.util.*;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 4) {
			return res;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {
				int head = j + 1;
				int tail = nums.length - 1;
				while (head < tail) {
					int tempSum = nums[i] + nums[j] + nums[head] + nums[tail];
					if (tempSum == target) {
						List<Integer> curr = new ArrayList<Integer>();
						// add in non-descending order
						curr.add(nums[i]);
						curr.add(nums[j]);
						curr.add(nums[head]);
						curr.add(nums[tail]);
						if (res.contains(curr) == false) {
							res.add(curr);
						}
						head++;
						tail--;
					} else if (tempSum < target) {
						head++;
					} else {
						tail--;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
