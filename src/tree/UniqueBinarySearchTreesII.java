// No.95
// some issues need to be reconsider

package tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	public static List<TreeNode> generateTrees(int n) {
		return assist(1, n);
	}

	public static List<TreeNode> assist(int start, int end) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (start > end) {
			res.add(null);
			return res;
		}

		for (int rootVal = start; rootVal <= end; rootVal++) {
			List<TreeNode> leftSubTrees = assist(start, rootVal - 1);
			List<TreeNode> rightSubTrees = assist(rootVal + 1, end);
			for (TreeNode leftSub : leftSubTrees) {
				for (TreeNode rightSub : rightSubTrees) {
					TreeNode root = new TreeNode(rootVal);
					root.left = leftSub;
					root.right = rightSub;
					res.add(root);
				}
			}
		}
		return res;
	}

	// issue remains
	public static List<TreeNode> generateTree(int n) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (n == 0) {
			res.add(null);
			return res;
		}
		helper(1, n, res);
		return res;
	}

	private static void helper(int start, int end, List<TreeNode> res) {
		if (start >= end) {
			res.add(null);
			return;
		}
		// TODO: fix this problem
		for (int i = start; i <= end; i++) {
			TreeNode root = new TreeNode(i);
			helper(start, root.val - 1, res);
			helper(root.val + 1, end, res);
			res.add(root);
		}
	}

	public static void main(String[] args) {
		List<TreeNode> res = generateTree(2);
		
		for (int i = 0; i < res.size(); i++) {
			TreeNode cur = res.get(i);
			System.out.println("---" + cur.val + "---");
			List<Integer> temp = preorderTraversal(cur);
			for (int j = 0; j < temp.size(); j++) {
				System.out.print(" " + temp.get(j) + " ");
			}
			System.out.println();
		}

	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		assist(root, res);
		return res;
	}

	private static void assist(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		res.add(root.val);
		assist(root.left, res);
		assist(root.right, res);
	}

}
