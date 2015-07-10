// No.114
// tricky

package list;

public class FlattenBinaryTreeToLinkedList {
	public static void flatten(TreeNode root) {
		if (root == null)
			return;

		flatten(root.left);
		flatten(root.right);

		// save current right node
		TreeNode right = root.right;

		if (root.left != null) {

			// concatinate root with left flatten subtree
			root.right = root.left;
			root.left = null;

			// move to the end of new added flatten subtree
			// important point
			while (root.right != null)
				root = root.right;

			// contatinate left flatten subtree with flatten right subtree
			root.right = right;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		flatten(root);
		while (root != null) {
			System.out.print(" - " + root.val + " - ");
			root = root.right;
		}
	}

}
