// No.31
// in place, tricky

package array;

public class NextPermutation {
	public static void nextPermutation(int[] nums) {
		int idx = find(nums);
		reverse(nums, idx + 1, nums.length - 1);
	}

	private static int find(int[] nums) {
		for (int i = nums.length - 2; i >= 0; i--) {
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[j] > nums[i]) {
					swap(nums, i, j);
					return i;
				}
			}
		}
		return -1;
	}

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[j];
		nums[j] = nums[i];
		nums[i] = tmp;
	}

	private static void reverse(int[] nums, int b, int e) {
		while (b < e) {
			swap(nums, b, e);
			b++;
			e--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
