// No.235

package tree;

public class LowestCommonAncestor {
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
			TreeNode q) {
		if (root == null) {
			return null;
		} else if (Math.max(p.val, q.val) < root.val) {
			if (root.left == p)
				return p;
			else if (root.left == q)
				return q;
			else
				return lowestCommonAncestor(root.left, p, q);
		} else if (Math.min(p.val, q.val) > root.val) {
			if (root.right == p)
				return p;
			else if (root.right == q)
				return q;
			else
				return lowestCommonAncestor(root.right, p, q);
		} else
			return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		System.out.println(lowestCommonAncestor(root, root.left.right, root.left).val);
	}

}
