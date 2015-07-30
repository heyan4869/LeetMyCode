// No.106

package tree;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTreeIntern(inorder, postorder, inorder.length - 1,
				postorder.length - 1, inorder.length);
	}

	private TreeNode buildTreeIntern(int[] inorder, int[] postorder,
			int inIndex, int postIndex, int size) {
		if (size <= 0) {
			return null;
		}
		TreeNode cur = new TreeNode(postorder[postIndex]);
		for (int i = 0; i < size; i++) {
			if (postorder[postIndex] == inorder[inIndex - i]) {
				cur.right = buildTreeIntern(inorder, postorder, inIndex,
						postIndex - 1, i);
				cur.left = buildTreeIntern(inorder, postorder, inIndex - i - 1,
						postIndex - i - 1, size - i - 1);
				break;
			}
		}
		return cur;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
