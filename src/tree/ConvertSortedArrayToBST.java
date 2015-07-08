// No.108
// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

package tree;

public class ConvertSortedArrayToBST {
	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		TreeNode res = assist(nums, 0, nums.length - 1);
		return res;
	}

	private static TreeNode assist(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode cur = new TreeNode(nums[mid]);
		cur.left = assist(nums, start, mid - 1);
		cur.right = assist(nums, mid + 1, end);
		return cur;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
