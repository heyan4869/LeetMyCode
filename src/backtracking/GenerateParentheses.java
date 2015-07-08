// No.22

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		if (n <= 0) {
			return res;
		}
		String cur = "";
		assist(cur, n, n, n, res);
		return res;
	}

	private static void assist(String cur, int left, int right, int n, List<String> res) {
		if (cur.length() == n * 2) {
			res.add(new String(cur));
			return;
		}
		if (left > 0) {
			assist(cur + "(", left - 1, right, n, res);
		}
		if (right > left) {
			assist(cur + ")", left, right - 1, n, res);
		}
	}

	public static void main(String[] args) {
		List<String> res = generateParenthesis(3);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(" " + res.get(i) + " ");
		}
	}

}
