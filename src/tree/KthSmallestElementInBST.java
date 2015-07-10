// No.230
// just use inorder traversal

package tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {
	public static int kthSmallest(TreeNode root, int k) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return 0;
		}
		assist(root, res);
		return res.get(k - 1);
	}

	private static void assist(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		assist(root.left, res);
		res.add(root.val);
		assist(root.right, res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
