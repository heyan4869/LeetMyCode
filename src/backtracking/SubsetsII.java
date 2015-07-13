// No.90
// sort first might be faster

package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	public static List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0) {
			res.add(new ArrayList<Integer>());
			return res;
		}
		res.add(new ArrayList<Integer>());
		List<Integer> temp = new ArrayList<Integer>();
		Boolean[] flag = new Boolean[num.length];
		Arrays.fill(flag, false);
		assist(num, temp, res, flag, Integer.MIN_VALUE);
		return res;
	}

	private static void assist(int[] num, List<Integer> temp,
			List<List<Integer>> res, Boolean[] flag, int minValue) {
		if (!res.contains(temp)) {
			res.add(new ArrayList<Integer>(temp));
		}
		for (int i = 0; i < num.length; i++) {
			if (!flag[i] && num[i] >= minValue) {
				temp.add(num[i]);
				flag[i] = true;
				assist(num, temp, res, flag, num[i]);
				temp.remove(temp.size() - 1);
				flag[i] = false;
			}
		}
		return;
	}

	public static void main(String[] args) {
		int[] num = {1, 2, 2};
		List<List<Integer>> res = subsetsWithDup(num);
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
