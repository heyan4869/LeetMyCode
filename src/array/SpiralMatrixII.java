// No.59
// tricky

package array;

public class SpiralMatrixII {
	public static int[][] generateMatrix(int n) {
		int[][] res = new int[n][n]; 
		if (n == 0) {
			return res;
		}
		int rowBegin = 0;
		int rowEnd = n - 1;
		int colBegin = 0;
		int colEnd = n - 1;
		int cur = 1;
		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			// traverse right
			for (int j = colBegin; j <= colEnd; j++) {
				res[rowBegin][j] = cur;
				cur++;
			}
			rowBegin++;
			
			// traverse down
			for (int j = rowBegin; j <= rowEnd; j++) {
				res[j][colEnd] = cur;
				cur++;
			}
			colEnd--;

			if (rowBegin <= rowEnd) {
				// traverse left
				for (int j = colEnd; j >= colBegin; j--) {
					res[rowEnd][j] = cur;
					cur++;
				}
			}
			rowEnd--;

			if (colBegin <= colEnd) {
				// traverse up
				for (int j = rowEnd; j >= rowBegin; j--) {
					res[j][colBegin] = cur;
					cur++;
				}
			}
			colBegin++;
		}

		return res;
	}

	public static void main(String[] args) {
		int[][] res = generateMatrix(3);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res.length; j++) {
				System.out.print(" " + res[i][j] + " ");
			}
			System.out.println();
		}

	}

}
