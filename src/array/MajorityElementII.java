// No.229
// linear time and O(1) space
// confused

package array;

import java.util.*;

public class MajorityElementII {
	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		if (nums.length == 0)
			return result;
		int a = nums[0], b = 0, acount = 0, bcount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != a) {
				b = nums[i];
				break;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == a) {
				acount++;
			} else if (nums[i] == b) {
				bcount++;
			} else {
				acount--;
				bcount--;
			}
			if (acount < 0) {
				a = nums[i];
				acount = 1;
			} else if (bcount < 0) {
				b = nums[i];
				bcount = 1;
			}
		}
		acount = bcount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == a)
				acount++;
			if (nums[i] == b)
				bcount++;
		}
		if (acount > nums.length / 3)
			result.add(a);
		if (bcount > nums.length / 3 && b != a)
			result.add(b);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
