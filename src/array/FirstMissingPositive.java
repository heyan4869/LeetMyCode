// No.41

package array;

public class FirstMissingPositive {
	public static int firstMissingPositive(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length)
				i++;
			else if (nums[nums[i] - 1] != nums[i])
				swap(nums, i, nums[i] - 1);
			else
				i++;
		}
		i = 0;
		while (i < nums.length && nums[i] == i + 1) {
			i++;
		}
		return i + 1;
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	// another solution
	public static int firstMissingPos(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int index = nums[start] - 1;
			if (index == start)
				start++;
			else if (index < 0 || index > end || nums[start] == nums[index])
				nums[start] = nums[end--];
			else {
				nums[start] = nums[index];
				nums[index] = index + 1;
			}
		}
		return start + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, -1, 1 };
		System.out.println(firstMissingPositive(nums));
	}

}
