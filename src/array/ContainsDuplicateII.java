// No.219

package array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums.length <= 1) {
			return false;
		}
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hm.containsKey(nums[i])) {
				if (i - hm.get(nums[i]) <= k) {
					return true;
				}
			}
			hm.put(nums[i], i);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
