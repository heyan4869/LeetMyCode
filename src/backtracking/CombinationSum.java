// No.39

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	public static List<List<Integer>> combinationSum(int[] candidates,
			int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0) {
			res.add(null);
			return res;
		}
		List<Integer> temp = new ArrayList<Integer>();
		assist(candidates, target, temp, res, 0, 0);
		return res;
	}

	private static void assist(int[] candidates, int target,
			List<Integer> temp, List<List<Integer>> res, int pre, int curSum) {
		if (curSum > target) {
			return;
		}
		if (curSum == target && !res.contains(temp)) {
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		for (int i = 0; i < candidates.length; i++) {
			if (candidates[i] >= pre) {
				temp.add(candidates[i]);
				assist(candidates, target, temp, res, candidates[i], curSum
						+ candidates[i]);
				temp.remove(temp.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] n = { 2, 3, 6, 7 };
		List<List<Integer>> res = combinationSum(n, 7);
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
