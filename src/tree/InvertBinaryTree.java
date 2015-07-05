// No.226

package tree;

public class InvertBinaryTree {
	public static TreeNode invertTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return root;
		}
		assist(root);
		return root;
	}

	private static void assist(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode leftBackup = root.left;
		TreeNode rightBackup = root.right;
		assist(root.left);
		assist(root.right);
		root.left = rightBackup;
		root.right = leftBackup;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		TreeNode curr = invertTree(root);
		System.out.println(curr.right.val);
	}

}
