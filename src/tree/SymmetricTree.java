// No.101

package tree;

public class SymmetricTree {
	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return assist(root, root);
	}

	private static boolean assist(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if ((left == null && right != null) || (left != null && right == null)) {
			return false;
		}
		if (left == right || left.val == right.val) {
			return assist(left.left, right.right) && assist(left.right, right.left);
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
		System.out.println(isSymmetric(root));
	}

}
