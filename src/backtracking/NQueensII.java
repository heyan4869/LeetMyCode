// No.52

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
	public static int totalNQueens(int n) {
		List<String> res = new ArrayList<String>();
		if (n == 0) {
			return 0;
		}
		List<String> temp = new ArrayList<String>();
		int[][] flag = new int[n][n];
		assist(n, 0, res, temp, flag);
		return res.size();
	}

	private static void assist(int n, int currow, List<String> res,
			List<String> temp, int[][] flag) {
		if (currow == n) {
			res.add("");
		}
		// row is determined by currow
		for (int j = 0; j < n; j++) {
			if (check(currow, j, flag)) {
				flag[currow][j] = 1;
				assist(n, currow + 1, res, temp, flag);
				flag[currow][j] = 0;
			}
		}
	}

	private static boolean check(int row, int col, int[][] flag) {
		for (int i = 0; i < flag.length; i++) {
			for (int j = 0; j < flag.length; j++) {
				if (i == row && flag[i][j] == 1)
					return false;
				if (j == col && flag[i][j] == 1)
					return false;
				if ((Math.abs(row - i) == Math.abs(col - j))
						&& (flag[i][j] == 1))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int res = totalNQueens(4);
		System.out.println(res);
	}
}
