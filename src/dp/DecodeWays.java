// No.91

package dp;

public class DecodeWays {
	public static int numDecodings(String s) {
		int len = s.length();
		if (len == 0) {
			return 0;
		}
		int[] dp = new int[len + 1];
		dp[len] = 1;
		dp[len - 1] = s.charAt(len - 1) != '0' ? 1 : 0;

		for (int i = len - 2; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				continue;
			} else {
				dp[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? dp[i + 1]
						+ dp[i + 2]
						: dp[i + 1];
			}
		}
		return dp[0];
	}

	// this solution fails
	public static int numDecoding(String s) {
		if (s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}
		if (s.length() == 1) {
			return s.charAt(0) != '0' ? 1 : 0;
		}
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = s.charAt(1) != '0' ? 1 : 0;
		for (int i = 2; i <= s.length(); i++) {
			if (s.charAt(i - 1) == '0') {
				continue;
			}
			if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2'
					&& s.charAt(i - 1) <= '6') {
				dp[i] = dp[i - 1] + dp[i - 2];
			} else {
				dp[i] = dp[i - 1];
			}
		}

		return dp[s.length()];
	}

	public static void main(String[] args) {
		System.out.println(numDecodings("1"));

	}

}
