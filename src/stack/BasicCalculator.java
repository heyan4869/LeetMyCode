// No.224
/*
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 */

package stack;

import java.util.Stack;

public class BasicCalculator {
	// not finished yet, could not deal with ( )
	public static int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		s = s.replace(" ", "");
		// Stack<Character> st = new Stack<Character>();
		
		return assist(s);
	}

	private static int assist(String s) {
		int idx = 0;
		int[] oper = new int[s.length() / 2];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
				continue;
			} else {
				oper[idx] = i;
				idx++;
			}
		}
		int res = Integer.parseInt(s.substring(0, oper[0]));
		for (int i = 0; i < idx; i++) {
			Character sign = s.charAt(oper[i]);
			int num = 0;
			if (i == idx - 1) {
				num = Integer.parseInt(s.substring(oper[i] + 1));
			} else {
				num = Integer.parseInt(s.substring(oper[i] + 1, oper[i + 1]));
			}
			if (sign == '+') {
				res = res + num;
			} else {
				res = res - num;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String s = "2 + 4 - 3";
		System.out.println(calculate(s));
	}

}
