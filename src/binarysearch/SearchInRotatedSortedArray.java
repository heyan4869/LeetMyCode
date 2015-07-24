// No.33
// tricky

package binarysearch;

public class SearchInRotatedSortedArray {
	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		return assist(nums, 0, nums.length - 1, target);
	}

	public static int assist(int[] nums, int start, int end, int target) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		if ((target < nums[mid] && target >= nums[start])
				|| (target >= nums[start] && nums[mid] < nums[start])
				|| (target < nums[mid] && nums[mid] < nums[start])) {
			return assist(nums, start, mid - 1, target);
		}
		return assist(nums, mid + 1, end, target);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
