// No.20

package string;

import java.util.Stack;

public class ValidParentheses {
	public static boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == '(' || cur == '[' || cur == '{') {
				st.push(cur);
			} else {
				if (st.isEmpty()) {
					return false;
				} else {
					char temp = st.pop();
					if (check(temp) != cur) {
						return false;
					}
				}
			}
		}
		if (st.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	private static char check(char temp) {
		if (temp == '(') {
			return ')';
		} else if (temp == '[') {
			return ']';
		} else {
			return '}';
		}
	}

	public static void main(String[] args) {
		System.out.println(isValid("(("));

	}

}
