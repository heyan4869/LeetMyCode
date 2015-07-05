// No.171

package math;

public class ExcelSheetColumnNumber {
	public static int titleToNumber(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}
		int res = 0;
		int len = s.length();
		for (int i = len; i > 0; i--) {
			res = (int) (Math.pow(26, len - i) * (int) (s.charAt(i - 1) - 64)) + res;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(titleToNumber("Z"));
	}

}
