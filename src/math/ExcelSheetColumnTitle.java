// No.168

package math;

public class ExcelSheetColumnTitle {
	// transfer A - Z to 0 - 25, thus (n - 1)
	public static String convertToTitle(int n) {
		String res = "";
		while (n != 0) {
			res = (char) ('A' + (n - 1) % 26) + res;
			n = (n - 1) / 26;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(convertToTitle(26));
	}

}
