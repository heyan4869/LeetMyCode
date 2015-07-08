package array;

public class SetMatrixZeros {
	public static void setZeroes(int[][] matrix) {
		if (matrix.length == 0) {
			return;
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					assist(matrix, i, j);
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 2147483646) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	private static void assist(int[][] matrix, int i, int j) {
		for (int row = 0; row < matrix.length; row++) {
			if (row != i) {
				if (matrix[row][j] != 0) {
					matrix[row][j] = 2147483646;
				}
			}
		}
		for (int col = 0; col < matrix[0].length; col++) {
			if (col != j) {
				if (matrix[i][col] != 0) {
					matrix[i][col] = 2147483646;
				}
			}
		}
	}

	// another reference solution, no need for unsafe 2147483646
	public void setZero(int[][] matrix) {
		boolean firstRow = false, firstCol = false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0)
						firstRow = true;
					if (j == 0)
						firstCol = true;
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (firstRow) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}
		if (firstCol) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
