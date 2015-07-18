// No.125

package string;

import java.util.Stack;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) >= 48 && s.charAt(i) <= 57)
					|| (s.charAt(i) >= 65 && s.charAt(i) <= 90)
					|| (s.charAt(i) >= 97 && s.charAt(i) <= 122)) {
				st.push(s.charAt(i));
			}
		}

		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) >= 48 && s.charAt(i) <= 57)
					|| (s.charAt(i) >= 65 && s.charAt(i) <= 90)
					|| (s.charAt(i) >= 97 && s.charAt(i) <= 122)) {
				if ((s.charAt(i) == st.peek())
						|| (s.charAt(i) == st.peek() + 32)
						|| (s.charAt(i) == st.peek() - 32)) {
					st.pop();
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("aA"));
	}

}
