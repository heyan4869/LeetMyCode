// No.9
// no bit solution is suitable

package math;

public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
		if(x < 0 || x == Integer.MAX_VALUE) {
			return false;
		}
		int palindromeX = 0;
		int inputX = x;
		while (x > 0) {
			palindromeX = palindromeX * 10 + (x % 10);
			x = x / 10;
		}
		return palindromeX == inputX;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
