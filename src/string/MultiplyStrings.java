// No.43
// tricky

package string;

public class MultiplyStrings {
	public static String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		int len1 = num1.length();
		int len2 = num2.length();
		int[] products = new int[len1 + len2];

		for (int i = len1 - 1; i >= 0; i--) {
			for (int j = len2 - 1; j >= 0; j--) {
				char c1 = num1.charAt(i);
				char c2 = num2.charAt(j);
				products[i + j + 1] += Integer.parseInt(String.valueOf(c1))
						* Integer.parseInt(String.valueOf(c2));

			}
		}

		int carry = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = len1 + len2 - 1; i >= 0; i--) {
			int temp = products[i] + carry;
			sb.append(temp % 10);
			carry = temp / 10;
		}
		sb.reverse();
		if (sb.charAt(0) == '0')
			sb.deleteCharAt(0);
		return sb.toString();
	}

	public static void main(String[] args) {
		String num1 = "12";
		String num2 = "6";
		System.out.println(multiply(num1, num2));
	}

}
