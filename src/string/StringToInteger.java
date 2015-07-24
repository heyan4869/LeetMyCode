// No.8

package string;

public class StringToInteger {
	public static int myAtoi(String str) {
		if (str == null || str.length() == 0)
			return 0;
		// trim whitespaces
		str = str.trim();
		// determine positive or negative
		int flag = 1;
		int i = 0;
		if (str.charAt(0) == '+') {
			flag = 1;
			i++;
		} else if (str.charAt(0) == '-') {
			flag = -1;
			i++;
		}
		// use double to avoid overflow of integer
		double res = 0;
		while (i < str.length() && str.charAt(i) - '0' <= 9
				&& str.charAt(i) - '0' >= 0) {
			res = res * 10 + (str.charAt(i) - '0');
			i++;
		}

		res *= flag;
		if (res > Integer.MAX_VALUE) {
			res = Integer.MAX_VALUE;
		} else if (res < Integer.MIN_VALUE) {
			res = Integer.MIN_VALUE;
		}
		return (int) res;
	}

	public static void main(String[] args) {
		String str = "332222231234";
		System.out.println(myAtoi(str));
	}

}
