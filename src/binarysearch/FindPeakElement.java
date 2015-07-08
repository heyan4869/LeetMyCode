// No.162
// tricky

package binarysearch;

public class FindPeakElement {
	// sequential search, smart
	public static int findPeakElement(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				return i - 1;
			}
		}
		return nums.length - 1;
	}

	// this solution fails at the assist function
	public static int findPeak(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		return assist(nums, 0, nums.length - 1);
	}

	private static int assist(int[] nums, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
			return mid;
		}
		if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid] + 1) {
			return assist(nums, mid + 1, end);
		}
		if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]) {
			return assist(nums, start, mid - 1);
		}
		if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
			if (nums[mid - 1] > nums[mid + 1]) {
				return assist(nums, start, mid - 1);
			} else {
				return assist(nums, mid + 1, end);
			}
		}

		return -1;
	}

	// correct recursion solution
	public static int helper(int[] nums, int low, int high) {
		if (low == high) {
			return low;
		} else {
			int mid1 = (low + high) / 2;
			int mid2 = mid1 + 1;
			if (nums[mid1] > nums[mid2])
				return helper(nums, low, mid1);
			else
				return helper(nums, mid2, high);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 2, 1, 3, 1 };
		System.out.println(findPeakElement(nums));

	}

}
