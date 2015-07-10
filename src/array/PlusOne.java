// No.66

package array;

public class PlusOne {
	public static int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return digits;
		}
		int flag = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int temp = digits[i] + flag;
			if (temp <= 9) {
				digits[i] = temp;
				flag = 0;
			} else {
				digits[i] = temp % 10;
				flag = 1;
			}
		}
		if (flag == 0) {
			return digits;
		} else {
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			return res;
		}
	}

	public static void main(String[] args) {
		int[] digits = { 9, 9, 9 };
		int[] res = plusOne(digits);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

	}

}
