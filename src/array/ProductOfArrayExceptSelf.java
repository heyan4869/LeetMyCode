// No.238
// smart

package array;

public class ProductOfArrayExceptSelf {
	public static int[] productExceptSelf(int[] nums) {
	    int len = nums.length;
	    int[] res = new int[len];
	    res[0] = 1;
	    for (int i = 1; i < len; i++) {
	        res[i] = res[i - 1] * nums[i - 1];
	    }
	    int right = 1;
	    for (int i = len - 1; i >= 0; i--) {
	        res[i] = res[i] * right;
	        right = nums[i] * right;
	    }
	    return res;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		int[] res = productExceptSelf(nums);
		for (int i = 0; i < res.length; i++) {
			System.out.print(" " + res[i] + " ");
		}
	}

}
