// No.150

package stack;

import java.util.*;

public class EvaluateReversePolishNotation {
	public static int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return -1;
		}
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+") || tokens[i].equals("-")
					|| tokens[i].equals("*") || tokens[i].equals("/")) {
				int a = st.pop();
				int b = st.pop();
				int temp = calculate(a, b, tokens[i]);
				st.push(temp);
			} else {
				st.push(Integer.parseInt(tokens[i]));
			}
		}
		return st.pop();
	}

	private static int calculate(int a, int b, String s) {
		if (s.equals("+")) {
			return b + a;
		} else if (s.equals("-")) {
			return b - a;
		} else if (s.equals("*")) {
			return b * a;
		} else {
			return b / a;
		}
	}

	public static void main(String[] args) {
		String[] tokens = new String[5];
		tokens[0] = "2";
		tokens[1] = "1";
		tokens[2] = "+";
		tokens[3] = "3";
		tokens[4] = "*";
		System.out.println(evalRPN(tokens));
	}

}
