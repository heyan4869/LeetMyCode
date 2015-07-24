// No.81

package binarysearch;

public class SearchInRotatedSortedArrayII {
	public static boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int length = nums.length;
		return assist(nums, target, 0, length - 1);
	}
	
	// this is O(n), since it ignored the fact of rotated sorted array
	public static boolean assist(int[] nums, int target, int start, int end) {
		if (start > end) {
			return false;
		}
		int mid = (start + end) / 2;
		if (nums[mid] == target) {
			return true;
		}
		return assist(nums, target, start, mid - 1)
				|| assist(nums, target, mid + 1, end);
	}
	
	// this is O(logn)
	public static boolean helper(int[] nums, int target, int start, int end) {
		if (start > end)
			return false;
		if (start == end)
			return nums[start] == target;

		int mid = (start + end) / 2;
		if (nums[mid] == target)
			return true;
		if (nums[mid] > nums[start]) {
			if (target < nums[mid] && target >= nums[start])
				return helper(nums, target, start, mid - 1);
			else
				return helper(nums, target, mid + 1, end);
		} else if (nums[mid] < nums[start]) {
			if (target > nums[mid] && target < nums[start])
				return helper(nums, target, mid + 1, end);
			else
				return helper(nums, target, start, mid - 1);
		} else
			return helper(nums, target, start, mid - 1)
					|| helper(nums, target, mid + 1, end);
	}

	public static void main(String[] args) {
		int[] nums = {1};
		System.out.println(search(nums, 2));
	}

}
