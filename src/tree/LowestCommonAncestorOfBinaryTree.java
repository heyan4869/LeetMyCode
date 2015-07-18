// No.236

package tree;

public class LowestCommonAncestorOfBinaryTree {
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
			TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		return left == null ? right : right == null ? left : root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
