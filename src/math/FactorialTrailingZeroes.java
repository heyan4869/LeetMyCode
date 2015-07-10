// No.172
// number of prime factor 5

package math;

public class FactorialTrailingZeroes {
	public static int trailingZeroes(int n) {
		int result = 0;
		while (n > 0) {
			result = result + n / 5;
			n /= 5;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
