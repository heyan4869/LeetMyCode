// No.113

package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}
		List<Integer> temp = new ArrayList<Integer>();
		assist(root, sum, 0, temp, res);
		return res;
	}

	private static void assist(TreeNode root, int sum, int curSum,
			List<Integer> temp, List<List<Integer>> res) {
		curSum += root.val;
		temp.add(root.val);
		if (curSum == sum && root.left == null && root.right == null) {
			res.add(new ArrayList<Integer>(temp));
			temp.remove(temp.size() - 1);
			return;
		}
		if (root.left != null) {
			assist(root.left, sum, curSum, temp, res);
		}
		if (root.right != null) {
			assist(root.right, sum, curSum, temp, res);
		}
		// this step helps fix the TLE problem
		temp.remove(temp.size() - 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		List<List<Integer>> res = pathSum(root, 9);
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
