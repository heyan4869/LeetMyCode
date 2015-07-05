// No.35
// Given a sorted array and a target value, return the index if the target is found
// If not, return the index where it would be if it were inserted in order

package binarysearch;

public class SearchInsertPosition {
	public static int searchInsert(int[] nums, int target) {
		if (nums.length == 0 || nums[0] >= target) {
        	return 0;
        }
        if (nums[nums.length - 1] < target) {
        	return nums.length;
        }
		return assist(nums, target, 0, nums.length - 1);
	}

	private static int assist(int[] nums, int target, int start, int end) {
		// notice this
		if (start == end) {
			return start;
		}
		int mid = (start + end) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		if (nums[mid] > target) {
			return assist(nums, target, start, mid);
		}
		if (nums[mid] < target) {
			assist(nums, target, mid + 1, end);
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3, 5, 8 };
		System.out.println(searchInsert(nums, 7));
	}

}
