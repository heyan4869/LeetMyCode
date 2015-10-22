package dp;

public class NimGame {
	public static boolean canWinNim(int n) {
		return (n % 4 != 0);
	}
	
	// out of memory
	public static boolean canWin(int n) {
		if (n <= 0) {
			return false;
		}
		if (n >= 1 && n <= 3) {
			return true;
		}
		boolean[] dp = new boolean[n + 1];
		dp[0] = false;
		dp[1] = true;
		dp[2] = true;
		dp[3] = true;
		for (int i = 4; i <= n; i++) {
			dp[i] = !dp[i - 1] && !dp[i - 2] && !dp[i - 3];
		}
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canWinNim(1348820612));
	}

}
