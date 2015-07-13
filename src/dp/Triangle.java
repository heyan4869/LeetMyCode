// No.120

package dp;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	public static int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.size() == 0 || triangle == null) {
			return 0;
		}
		if (triangle.size() == 1) {
			return triangle.get(0).get(0);
		}
		// List<List<Integer>> dp = triangle;
		List<int[]> map = new ArrayList<int[]>();
		for (int i = 0; i < triangle.size(); i++) {
			map.add(new int[triangle.get(i).size()]);
		}
		map.get(0)[0] = triangle.get(0).get(0);
		for (int i = 1; i < triangle.size(); i++) {
			int temp1 = map.get(i - 1)[0] + triangle.get(i).get(0);
			map.get(i)[0] = temp1;
			int temp2 = map.get(i - 1)[map.get(i - 1).length - 1] + triangle.get(i).get(triangle.get(i).size() - 1);
			map.get(i)[map.get(i).length - 1] = temp2;
		}
		for (int i = 2; i < triangle.size(); i++) {
			for (int j = 1; j < triangle.get(i).size() - 1; j++) {
				int temp = Math.min(map.get(i - 1)[j - 1], map.get(i - 1)[j]) + triangle.get(i).get(j);
				map.get(i)[j] = temp;
			}
		}
		int[] allSum = map.get(triangle.size() - 1);
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < allSum.length; i++) {
			res = Math.min(res, allSum[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		List<List<Integer>> tri = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(2);
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(3);
		l2.add(4);
		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(6);
		l3.add(5);
		l3.add(7);
		List<Integer> l4 = new ArrayList<Integer>();
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		tri.add(l1);
		tri.add(l2);
		tri.add(l3);
		tri.add(l4);
		System.out.println(minimumTotal(tri));
	}

}
