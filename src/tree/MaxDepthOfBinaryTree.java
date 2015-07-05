// No.104

package tree;

public class MaxDepthOfBinaryTree {
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return assist(root);
	}
	
	// Recursion to compare left and right max depth
	private static int assist(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(assist(root.left),
				assist(root.right));
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(10);
		System.out.println(maxDepth(root));
	}

}
