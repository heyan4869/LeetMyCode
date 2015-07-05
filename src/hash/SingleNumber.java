package hash;

import java.util.HashSet;
import java.util.Set;

// No.136

public class SingleNumber {
	// My solution using HashSet
	public static int singleNumber(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return 0;
		}
		Set<Integer> hs = new HashSet<Integer>();
		int allSum = 0;
		int singleSum = 0;
		for (int i = 0; i < nums.length; i++) {
			allSum += nums[i];
			if (!hs.contains(nums[i])) {
				singleSum += nums[i];
				hs.add(nums[i]);
			} else {
				continue;
			}
		}
		return singleSum * 2 - allSum;
	}

	// Reference solution using XOR
	public static int singleNum(int[] nums) {
		int a = 0;
		for (int i : nums)
			a ^= i;
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 3, 3, 5 };
		System.out.println(singleNumber(nums));
	}

}
