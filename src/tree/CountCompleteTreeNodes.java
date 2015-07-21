// No.222
// confused

package tree;

public class CountCompleteTreeNodes {
	public static int countNodes(TreeNode root) {
		int num = 0, h = height(root);
		while (root != null) {
			if (height(root.right) == h - 1) {
				num += 1 << h;
				root = root.right;
			} else {
				num += 1 << h - 1;
				root = root.left;
			}
			h--;
		}
		return num;
	}

	private static int height(TreeNode root) {
		return root == null ? -1 : 1 + height(root.left);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
