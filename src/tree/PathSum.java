// No.112

package tree;

public class PathSum {
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		return assist(root, 0, sum);
	}

	private static boolean assist(TreeNode root, int preSum, int sum) {
		if (root == null) {
			return false;
		}
		preSum += root.val;
		if (preSum == sum && root.left == null && root.right == null) {
			return true;
		}
		return assist(root.left, preSum, sum) || assist(root.right, preSum, sum);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		System.out.println(hasPathSum(root, 3));
	}

}
