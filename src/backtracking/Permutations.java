// No.46

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public static List<List<Integer>> permute(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0) {
			return res;
		}
		int[] flag = new int[num.length];
		List<Integer> cur = new ArrayList<Integer>();
		assist(cur, flag, num, res);

		return res;
	}

	private static void assist(List<Integer> cur, int[] flag, int[] num,
			List<List<Integer>> res) {
		if (cur.size() == num.length) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (flag[i] == 0) {
				cur.add(num[i]);
				flag[i] = 1;
				assist(cur, flag, num, res);
				cur.remove(cur.size() - 1);
				flag[i] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 3 };
		List<List<Integer>> res = permute(num);
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
