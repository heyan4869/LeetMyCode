// No.89

package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrayCode {
	public static List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer>();
		Set<Integer> hs = new HashSet<Integer>();
		res.add(0);
		hs.add(0);
		assist(0, n, res, hs);
		return res;
	}

	private static void assist(int pre, int n, List<Integer> res,
			Set<Integer> hs) {
		if (res.size() == Math.pow(2, n)) {
			return;
		}
		for (int i = 0; i < n; i++) {
			int temp = pre ^ (1 << i);
			if (!hs.contains(temp)) {
				res.add(temp);
				hs.add(temp);
				assist(temp, n, res, hs);
				
				// since we only need one valid result, no need
				// res.remove(res.size() - 1);
				// hs.remove(temp);
			}
		}
	}

	public static void main(String[] args) {
		List<Integer> res = grayCode(2);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(" " + res.get(i) + " ");
		}

	}

}
