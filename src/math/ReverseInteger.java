// No.7

package math;

public class ReverseInteger {
	public static int reverse(int x) {
		long result = 0;
		// long type is for compare. 
		// Only larger range can compare Max and Min Integer

		while (x != 0) {
			int mod = x % 10;
			x = x / 10;
			result = result * 10 + mod;
			if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
				return 0;
		}
		return (int) result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
