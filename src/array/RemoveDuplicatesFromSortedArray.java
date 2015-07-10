// No.26
// Given a sorted array, remove the duplicates in place such that 
// each element appear only once and return the new length

package array;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray {
	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int p1 = 0;
		int p2 = 0;
		Set<Integer> hs = new HashSet<Integer>();
		while (p1 < nums.length && p2 < nums.length) {
			if (!hs.contains(nums[p1])) {
				hs.add(nums[p1]);
				p1++;
				p2++;
			} else {
				while (p2 < nums.length && hs.contains(nums[p2])) {
					p2++;
				}
				if (p2 == nums.length) {
					return p1;
				} else {
					nums[p1] = nums[p2];
					hs.add(nums[p1]);
					p1++;
					p2++;
				}
			}
		}
		return p1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1 };
		System.out.println(removeDuplicates(nums));
		for (int i = 0; i < nums.length; i++) {
			System.out.print(" " + nums[i] + " ");
		}
	}

}
