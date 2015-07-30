// No.216

package backtracking;

import java.util.*;

public class CombinationSumIII {
	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (n == 0) {
			return res;
		}
		List<Integer> temp = new ArrayList<Integer>();
		assist(k, n, 1, 0, temp, res);
		return res;
	}
	
	private static void assist(int k, int n, int start, int cursum, List<Integer> temp,
			List<List<Integer>> res) {
		if (cursum == n && temp.size() == k) {
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		for (int i = start; i <= 9; i++) {
			if (cursum + i <= n) {
				temp.add(i);
				cursum += i;
				assist(k, n, i + 1, cursum, temp, res);
				temp.remove(temp.size() - 1);
				cursum -= i;
			}
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> res = combinationSum3(3, 9);
		for (int i = 0; i < res.size(); i++) {
			List<Integer> temp = res.get(i);
			for (int j = 0; j < temp.size(); j++) {
				System.out.print(temp.get(j) + " ");
			}
			System.out.println();
		}
	}

}
