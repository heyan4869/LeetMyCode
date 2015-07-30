// No.85

package dp;

public class MaximalRectangle {
	public static int maximalRectangle(char[][] matrix) {
		int area = 0;
		int numRows = matrix.length;
		if (numRows == 0)
			return 0;
		int numCols = matrix[0].length;
		if (numCols == 0)
			return 0;
		int[][] rowArea = new int[numRows][numCols];
		for (int i = 0; i < numRows; i++) { // y
			for (int j = 0; j < numCols; j++) {
				if (matrix[i][j] == '0') {
					continue;
				} else {
					if (j == 0)
						rowArea[i][j] = 1;
					else {
						rowArea[i][j] = rowArea[i][j - 1] + 1;
					}
					int y = 1;
					int x = numCols;
					while (i - y + 1 >= 0 && rowArea[i - y + 1][j] > 0) {
						x = Math.min(x, rowArea[i - y + 1][j]);
						area = Math.max(area, x * y);
						y++;
					}
				}
			}
		}
		return area;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
