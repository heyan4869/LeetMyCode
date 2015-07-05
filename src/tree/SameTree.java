// No.100

package tree;

public class SameTree {
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		return assist(p, q);
	}

	private static boolean assist(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if ((p != null && q == null) || (p == null && q != null)) {
			return false;
		}
		if (p != null && q != null) {
			if (p.val != q.val) {
				return false;
			} else {
				return assist(p.left, q.left) && assist(p.right, q.right);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode p = null;
		TreeNode q = new TreeNode(5);
		// p.left = new TreeNode(5);
		// q.left = new TreeNode(5);
		System.out.println(isSameTree(p, q));

	}

}
