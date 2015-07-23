// No.233
// tricky
// Given an integer n, count the total number of digit 1 appearing 
// in all non-negative integers less than or equal to n

package math;

public class NumberOfDigitOne {
	public static int countDigitOne(int n) {
		if (n <= 0) {
			return 0;
		}
		int j = 1;
		int k = n;
		int constant = 0;
		while (k >= 10) {
			k = k / 10;
			j = j * 10;
		}
		if (k > 1) {
			constant = j;
		} else {
			constant = n % j + 1;
		}
		return constant + k * countDigitOne(j - 1) + countDigitOne(n % j);
	}

	public static void main(String[] args) {
		System.out.println(countDigitOne(11));
	}

}
