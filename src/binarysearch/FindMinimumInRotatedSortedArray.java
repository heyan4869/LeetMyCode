// No.153
// Suppose a sorted array is rotated at some pivot unknown to you beforehand
// Assume no duplicate, find the minimum element
package binarysearch;

public class FindMinimumInRotatedSortedArray {
	public static int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			if (nums[0] > nums[1]) {
				return nums[1];
			} else {
				return nums[0];
			}
		}
		return assist(nums, 0, nums.length - 1);
	}

	private static int assist(int[] nums, int start, int end) {
		if (start > end) {
			return -1;
		}
		// incase only two element left
		if (end - start == 1 && nums[start] > nums[end]) {
			return nums[end];
		}
		// compare the start, mid, end
		int mid = (start + end) / 2;
		if (nums[mid] < nums[mid] - 1) {
			return nums[mid];
		}
		if (nums[start] < nums[mid] && nums[mid] > nums[end]) {
			return assist(nums, mid, end);
		}
		if (nums[start] > nums[mid] && nums[mid] < nums[end]) {
			return assist(nums, start, mid);
		}
		// incase the array is sorted
		if (nums[start] < nums[mid] && nums[mid] < nums[end]) {
			return nums[start];
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = {4, 5, 6};
		System.out.println(findMin(nums));
	}

}
