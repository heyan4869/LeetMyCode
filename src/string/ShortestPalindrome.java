// No.214

package string;

public class ShortestPalindrome {
	public static String shortestPalindrome(String s) {
		if (s.length() <= 1)
			return s;
		int mid = (s.length() - 1) / 2;
		String res = "";
		for (int i = mid; i >= 0; i--) {
			// two situation, single mid or double mid
			if (s.charAt(i) == s.charAt(i + 1)) {
				if ((res = check(s, i, i + 1)) != null) {
					return res;
				}
			}
			if ((res = check(s, i, i)) != null) {
				return res;
			}

		}
		return res;
	}

	private static String check(String s, int l, int r) {
		int i = 1;
		for (i = 1; l - i >= 0; i++) {
			// remember to check the boundary
			if (l - i < 0 || r + i >= s.length() || s.charAt(l - i) != s.charAt(r + i))
				break;
		}

		if (l - i >= 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder(s.substring(r + i));
		sb.reverse();
		return sb + s;
	}

	public static void main(String[] args) {
		String s = "abb";
		System.out.println(shortestPalindrome(s));
	}

}
