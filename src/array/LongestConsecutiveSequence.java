// No.128
// tricky

package array;

import java.util.*;

public class LongestConsecutiveSequence {
	public static int longestConsecutive(int[] nums) {
		int maxlen = 0;
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hm.containsKey(nums[i])) {
				continue;
			}
			hm.put(nums[i], 1);

			int end = nums[i];
			int begin = nums[i];
			if (hm.containsKey(nums[i] + 1)) {
				end = nums[i] + hm.get(nums[i] + 1);
			}
			if (hm.containsKey(nums[i] - 1)) {
				begin = nums[i] - hm.get(nums[i] - 1);
			}
			hm.put(end, end - begin + 1);
			hm.put(begin, end - begin + 1);
			maxlen = Math.max(maxlen, end - begin + 1);
		}
		return maxlen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
