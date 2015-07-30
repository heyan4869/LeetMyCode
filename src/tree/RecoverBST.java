// No.99
// tricky recursion

package tree;

public class RecoverBST {
	public void recoverTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;
		TreeNode[] targets = new TreeNode[2];
		checkElement(root, null, targets);
		if (targets[0] != null && targets[1] != null) {
			// swap
			int temp = targets[0].val;
			targets[0].val = targets[1].val;
			targets[1].val = temp;
		}
	}

	// tricky recursion
	private TreeNode checkElement(TreeNode cur, TreeNode pioneer,
			TreeNode[] targets) {
		// If current node has left node, then pass the pioneer to the left,
		// if current node have no left node, then passed-in pioneer is current
		// node's pioneer,compare them to decide the swapped nodes.
		if (cur.left != null) {
			pioneer = checkElement(cur.left, pioneer, targets);
		}

		// if pioneer is null, then the current node is the first node
		if (pioneer != null) {
			if (cur.val < pioneer.val) {
				if (targets[0] == null)
					targets[0] = pioneer;
				targets[1] = cur;
			}
		}
		if (cur.right != null)
			return checkElement(cur.right, cur, targets);
		else
			return cur;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
