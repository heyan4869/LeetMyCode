// No.173

package tree;

import java.util.Stack;

public class BSTIterator {
	private Stack<TreeNode> s;
	TreeNode curr = null;

	public BSTIterator(TreeNode root) {
		curr = root;
		s = new Stack<TreeNode>();
		if (root != null) {
			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !s.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = s.pop();
		TreeNode temp = node.right;
		if (temp != null) {
			while (temp != null) {
				s.push(temp);
				temp = temp.left;
			}
		}
		return node.val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
