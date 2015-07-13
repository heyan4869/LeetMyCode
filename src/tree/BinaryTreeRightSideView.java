// No.199

package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryTreeRightSideView {
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		Set<Integer> hs = new HashSet<Integer>();
		assist(root, 1, hs, res);
		return res;
	}

	private static void assist(TreeNode root, int level, Set<Integer> hs,
			List<Integer> res) {
		if (root == null) {
			return;
		}
		if (!hs.contains(level)) {
			res.add(root.val);
			hs.add(level);
		}
		assist(root.right, level + 1, hs, res);
		assist(root.left, level + 1, hs, res);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		List<Integer> res = rightSideView(root);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}

}
