// No.233
// tricky!
// Given an integer n, count the total number of digit 1 appearing 
// in all non-negative integers less than or equal to n

package math;

public class NumberOfDigitOne {
	public static int countDigitOne(int n) {
		int ones = 0;
		for (long m = 1; m <= n; m *= 10) {
			ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
		}
		return ones;
	}

	public static void main(String[] args) {
		System.out.println(countDigitOne(11));
	}

}
