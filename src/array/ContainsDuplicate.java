// No.217

package array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	public static boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		Set<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hs.contains(nums[i])) {
				return true;
			} else {
				hs.add(nums[i]);
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 4, 4, 5};
		System.out.println(containsDuplicate(nums));
	}

}
