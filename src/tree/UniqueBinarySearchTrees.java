// No.96
// a little tricky
// How many unique binary search trees that store values 1 ~ n
package tree;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTrees {
	public static int numTrees(int n) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm.put(0, 1);
		hm.put(1, 1);
		return numTrees(n, hm);
	}

	private static int numTrees(int n, Map<Integer, Integer> hm) {
		// check hashmap
		if (hm.containsKey(n))
			return hm.get(n);
		// recursion
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum = sum + numTrees(i - 1, hm) * numTrees(n - i, hm);
		}
		hm.put(n, sum);
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(numTrees(3));
	}

}
