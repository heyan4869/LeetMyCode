// No.161

package tree;

public class NextRightPointers {
	public static void connect(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode leftside = root;
		while (leftside != null && leftside.left != null) {
			TreeLinkNode traversal = leftside;
			while (traversal != null) {
				// if parent has left child, point to its right child
				if (traversal.left != null) {
					traversal.left.next = traversal.right;
				}

				// if parent has next node, point its right child to
				// its next node's left child
				if (traversal.right != null && traversal.next != null) {
					traversal.right.next = traversal.next.left;
				}

				// make sure to go throught the whole level
				traversal = traversal.next;
			}
			// always take the most left path
			leftside = leftside.left;
		}
	}

	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(3);
		root.left = new TreeLinkNode(1);
		root.right = new TreeLinkNode(5);
		// root.left.left = new TreeLinkNode(1);
		// root.right.left = new TreeLinkNode(4);
		connect(root);
	}

}
