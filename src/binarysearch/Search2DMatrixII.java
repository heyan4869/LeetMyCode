// No.240

package binarysearch;

public class Search2DMatrixII {
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		return assist(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
	}

	private static boolean assist(int[][] matrix, int target, int uprow,
			int upcol, int downrow, int downcol) {
		if (uprow > downrow || upcol > downcol
				|| target < matrix[uprow][upcol] || target > matrix[downrow][downcol]) {
			return false;
		}
		int midrow = (uprow + downrow) / 2;
		int midcol = (upcol + downcol) / 2;
		if (target == matrix[midrow][midcol]) {
			return true;
		}
		if (target < matrix[midrow][midcol]) {
			return assist(matrix, target, uprow, upcol, midrow, midcol)
					|| assist(matrix, target, uprow, midcol + 1, midrow, downcol)
					|| assist(matrix, target, midrow + 1, upcol, downrow, midcol);
		}
		if (target > matrix[midrow][midcol]) {
			return assist(matrix, target, midrow + 1, midcol + 1, downrow, downcol)
					|| assist(matrix, target, uprow, midcol + 1, midrow, downcol)
					|| assist(matrix, target, midrow + 1, upcol, downrow, midcol);
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] m = new int[5][5];
		m[0][0] = 1;
		m[0][1] = 4;
		m[0][2] = 7;
		m[0][3] = 11;
		m[0][4] = 15;
		
		m[1][0] = 2;
		m[1][1] = 5;
		m[1][2] = 8;
		m[1][3] = 12;
		m[1][4] = 19;
		
		m[2][0] = 3;
		m[2][1] = 6;
		m[2][2] = 9;
		m[2][3] = 16;
		m[2][4] = 22;
		
		m[3][0] = 10;
		m[3][1] = 13;
		m[3][2] = 14;
		m[3][3] = 17;
		m[3][4] = 24;
		
		m[4][0] = 18;
		m[4][1] = 21;
		m[4][2] = 23;
		m[4][3] = 26;
		m[4][4] = 30;
		
		System.out.println(searchMatrix(m, 26));
	}

}
