// No.174

package dp;

public class DungeonGame {
	public static int calculateMinimumHP(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0) {
			return -1;
		}
		int row = dungeon.length;
		int col = dungeon[0].length;
		int[][] dp = new int[row][col];
		dp[row - 1][col - 1] = Math.max((0 - dungeon[row - 1][col - 1]) + 1, 1);
		// last col
		for (int i = dungeon.length - 2; i >= 0; i--) {
			dp[i][col - 1] = Math.max(dp[i + 1][col - 1] - dungeon[i][col - 1], 1);
		}
		// last row
		for (int j = dungeon[0].length - 2; j >= 0; j--) {
			dp[row - 1][j] = Math.max(dp[row - 1][j + 1] - dungeon[row - 1][j], 1);
		}
		// rest
		for (int i = dungeon.length - 2; i >= 0; i--) {
			for (int j = dungeon[0].length - 2; j >= 0; j--) {
				dp[i][j] = Math.min(Math.max(dp[i + 1][j] - dungeon[i][j], 1), Math.max(dp[i][j + 1] - dungeon[i][j], 1));
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		int[][] dungeon = new int[3][3];
		dungeon[0][0] = -2;
		dungeon[0][1] = -3;
		dungeon[0][2] = 3;
		dungeon[1][0] = -5;
		dungeon[1][1] = -10;
		dungeon[1][2] = 1;
		dungeon[2][0] = 10;
		dungeon[2][1] = 30;
		dungeon[2][2] = -5;
		System.out.println(calculateMinimumHP(dungeon));
	}

}
