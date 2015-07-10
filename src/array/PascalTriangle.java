// No.118

package array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int n = 0; n < numRows; n++) {
			List<Integer> tri = new ArrayList<Integer>(n + 1);
			// get the size right
			for (int i = 0; i <= n; i++) {
				tri.add(0);
			}
			tri.set(0, 1);
			// this is core
			for (int i = 1; i <= n; i++) {
				tri.set(i, 1);
				for (int j = i - 1; j > 0; j--) {
					tri.set(j, tri.get(j) + tri.get(j - 1));
				}
			}
			res.add(tri);
		}
		return res;
	}

	public static void main(String[] args) {
		List<List<Integer>> res = generate(3);
		for (int i = 0; i < res.size(); i++) {
			List<Integer> level = res.get(i);
			for (int j = 0; j < level.size(); j++) {
				System.out.print(" " + level.get(j) + " ");
			}
			System.out.println();
		}
	}

}
