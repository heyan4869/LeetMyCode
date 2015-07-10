// No.111

package tree;

public class MinimumDepthOfBinaryTree {
	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return assist(root, 1);
	}

	private static int assist(TreeNode root, int level) {
		if (root != null && root.left == null && root.right == null) {
			return level;
		}
		if (root.left != null && root.right == null) {
			return assist(root.left, level + 1);
		} else if (root.left == null && root.right != null) {
			return assist(root.right, level + 1);
		} else {
			return Math.min(assist(root.left, level + 1),
					assist(root.right, level + 1));
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(9);
		root.left.left = new TreeNode(5);
		System.out.println(minDepth(root));
	}

}
