// No.63

package dp;

public class UniquePathsII {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] map = new int[m][n];
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				if (n == 1)
					return 0;
				break;
			} else {
				map[i][0] = 1;
			}
		}
		for (int j = 0; j < n; j++) {
			if (obstacleGrid[0][j] == 1) {
				if (m == 1)
					return 0;
				break;
			} else {
				map[0][j] = 1;
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 0) {
					map[i][j] = map[i - 1][j] + map[i][j - 1];
				}
			}
		}
		return map[m - 1][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
