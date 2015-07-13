// No.47

package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
	// reference solution
	public static List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		permute(nums, 0, nums.length - 1, res);
		return res;
	}

	public static void permute(int[] nums, int start, int end, List<List<Integer>> res) {
		if (start == end) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int x : nums)
				list.add(x);
			res.add(list);
			return;
		}
		HashSet<Integer> visited = new HashSet<Integer>();
		for (int k = start; k <= end; k++) {
			if (!visited.contains(nums[k])) {
				swap(nums, start, k);
				permute(nums, start + 1, end, res);
				swap(nums, start, k);
				visited.add(nums[k]);
			}
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int tmp = nums[j];
		nums[j] = nums[i];
		nums[i] = tmp;
	}

	// this got TLE, why?
	public static List<List<Integer>> permuteUniq(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		List<Integer> temp = new ArrayList<Integer>();
		int[] flag = new int[nums.length];
		Set<List<Integer>> hs = new HashSet<List<Integer>>();
		assist(nums, res, temp, flag, hs);
		return res;
	}

	private static void assist(int[] nums, List<List<Integer>> res,
			List<Integer> temp, int[] flag, Set<List<Integer>> hs) {
		if (temp.size() == nums.length
				&& !hs.contains(new ArrayList<Integer>(temp))) {
			res.add(new ArrayList<Integer>(temp));
			hs.add(new ArrayList<Integer>(temp));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (flag[i] == 0) {
				temp.add(nums[i]);
				flag[i] = 1;
				assist(nums, res, temp, flag, hs);
				temp.remove(temp.size() - 1);
				flag[i] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };
		List<List<Integer>> res = permuteUnique(nums);
		for (int i = 0; i < res.size(); i++) {
			List<Integer> temp = res.get(i);
			for (int j = 0; j < temp.size(); j++) {
				System.out.print(" " + temp.get(j) + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
