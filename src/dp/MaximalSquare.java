// No.221

package dp;

public class MaximalSquare {
	public static int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] dp = new int[row][col];
		int max = 0;
		for (int i = 0; i < row; i++) {
			if (matrix[i][0] == '1') {
				dp[i][0] = 1;
				max = 1;
			}
		}
		for (int j = 0; j < col; j++) {
			if (matrix[0][j] == '1') {
				dp[0][j] = 1;
				max = 1;
			}
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (dp[i - 1][j - 1] == 0 || dp[i - 1][j] == 0 || dp[i][j - 1] == 0) {
					if (matrix[i][j] == '1') {
						dp[i][j] = 1;
					}
				} else if (Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) != 0) {
					if (matrix[i][j] == '1') {
						dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
						max = Math.max(max, dp[i][j]);
					}
				}
			}
		}
		return (int) Math.pow(max, 2);
	}

	public static void main(String[] args) {
		char[][] matrix = new char[4][5];
		matrix[0][0] = '1';
		matrix[0][1] = '0';
		matrix[0][2] = '1';
		matrix[0][3] = '0';
		matrix[0][4] = '0';
		matrix[1][0] = '1';
		matrix[1][1] = '0';
		matrix[1][2] = '1';
		matrix[1][3] = '1';
		matrix[1][4] = '1';
		matrix[2][0] = '1';
		matrix[2][1] = '1';
		matrix[2][2] = '1';
		matrix[2][3] = '1';
		matrix[2][4] = '1';
		matrix[3][0] = '1';
		matrix[3][1] = '0';
		matrix[3][2] = '1';
		matrix[3][3] = '1';
		matrix[3][4] = '0';
		System.out.println(maximalSquare(matrix));
	}

}
