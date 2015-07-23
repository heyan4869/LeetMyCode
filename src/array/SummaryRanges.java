// No.228

package array;

import java.util.*;

public class SummaryRanges {
	public static List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		if (nums.length == 1) {
			String temp = nums[0] + "";
			res.add(temp);
			return res;
		}
		int p1 = 0;
		int p2 = 0;
		while (p1 < nums.length && p2 < nums.length - 1) {
			if (nums[p2] + 1 == nums[p2 + 1]) {
				p2++;
			} else {
				if (p2 - p1 >= 1) {
					String temp = nums[p1] + "->" + nums[p2];
					res.add(temp);
					p2++;
					p1 = p2;
				} else {
					String temp = nums[p2] + "";
					res.add(temp);
					p2++;
					p1 = p2;
				}
			}
		}
		if (p2 - p1 >= 1) {
			String temp = nums[p1] + "->" + nums[p2];
			res.add(temp);
			p2++;
			p1 = p2;
		} else {
			String temp = nums[p2] + "";
			res.add(temp);
			p2++;
			p1 = p2;
		}
		
		return res;
	}
	public static void main(String[] args) {
		int[] nums = {0, 2};
		List<String> res = summaryRanges(nums);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(" - " + res.get(i) + " - ");
		}
	}

}
