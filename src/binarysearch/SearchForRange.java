// No.34

package binarysearch;

public class SearchForRange {
	public static int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
		if (nums == null || nums.length == 0) {
			res[0] = -1;
			res[1] = -1;
			return res;
		}
		if (nums.length == 1) {
			if (nums[0] == target) {
				res[0] = 0;
				res[1] = 0;
				return res;
			} else {
				res[0] = -1;
				res[1] = -1;
				return res;
			}
		}
		res[0] = findStart(nums, target, 0, nums.length - 1);
		if (res[0] == -1) {
			res[1] = -1;
			return res;
		} else {
			res[1] = findEnd(nums, target, res[0] + 1, nums.length - 1);
			if (res[1] == -1) {
				res[1] = res[0];
				return res;
			}
		}
		return res;

	}

	private static int findStart(int[] nums, int target, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		// remember to check if mid == start first
		if ((nums[mid] == target && mid == start) || (nums[mid] == target && nums[mid] > nums[mid - 1])) {
			return mid;
		}
		if (nums[mid] == target && nums[mid] == nums[mid - 1]) {
			return findStart(nums, target, start, mid - 1);
		}
		if (nums[mid] > target) {
			return findStart(nums, target, start, mid - 1);
		}
		if (nums[mid] < target) {
			return findStart(nums, target, mid + 1, end);
		}
		return -1;
	}

	private static int findEnd(int[] nums, int target, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if ((nums[mid] == target && mid == end) || (nums[mid] == target && nums[mid] < nums[mid + 1])) {
			return mid;
		}
		if (nums[mid] == target && nums[mid] == nums[mid + 1]) {
			return findEnd(nums, target, mid + 1, end);
		}
		if (nums[mid] > target) {
			return findEnd(nums, target, start, mid - 1);
		}
		if (nums[mid] < target) {
			return findEnd(nums, target, mid + 1, end);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = {0, 0, 0, 1, 2, 3};
		int target = 0;
		int[] res = searchRange(nums, target);
		System.out.print(res[0] + " " + res[1]);
	}

}
