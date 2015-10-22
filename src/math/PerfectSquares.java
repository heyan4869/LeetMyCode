package math;

public class PerfectSquares {
	public static int numSquares(int n) {
		// dp[n] = Min{ dp[n - i * i] + 1 }, n - i * i >= 0 && i >= 1
		int[] dp = new int[n + 1];
		int nearest;
		for (int i = 1; i <= n; i++) {
			nearest = (int) Math.sqrt(i);
			int min = dp[i - 1];
			for (int j = nearest; j > 0; j--) {
				if (dp[i - j * j] < min)
					min = dp[i - j * j];
			}
			dp[i] = min + 1;
		}
		return dp[n];
	}

	// TLE
	public static int numSquare(int n) {
		if (n <= 0) {
			return -1;
		}
		int res = Integer.MAX_VALUE;
		return assist(n, res, 0);
	}

	private static int assist(int n, int res, int count) {
		if (n == 0) {
			return count;
		}
		for (int i = (int) Math.sqrt(n); i >= 1; i--) {
			if (n - i * i >= 0) {
				res = Math.min(assist(n - i * i, res, count + 1), res);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		System.out.println(numSquares(n));
	}

}
