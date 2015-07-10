// No.129

package tree;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {
	public static int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		List<Integer> res = new ArrayList<Integer>();
		assist(root, 0, res);
		int sum = 0;
		for (int i = 0; i < res.size(); i++) {
			sum += res.get(i);
		}
		return sum;
	}

	private static void assist(TreeNode root, int pre, List<Integer> res) {
		pre = pre * 10 + root.val;
		if (root.left == null && root.right == null) {
			res.add(pre);
			return;
		}
		if (root.left != null) {
			assist(root.left, pre, res);
		}
		if (root.right != null) {
			assist(root.right, pre, res);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(sumNumbers(root));

	}

}
