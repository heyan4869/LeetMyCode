// No.74
// Integers in each row are sorted from left to right
// The first integer of each row is greater than the last integer of the previous row

package binarysearch;

public class Search2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		return findRow(matrix, target, 0, matrix.length - 1);

	}

	private static boolean findRow(int[][] matrix, int target, int startRow,
			int endRow) {
		if (startRow > endRow) {
			return false;
		}
		int midRow = (startRow + endRow) / 2;
		if (matrix[midRow][0] <= target
				&& matrix[midRow][matrix[0].length - 1] >= target) {
			return findCol(matrix[midRow], target, 0, matrix[0].length - 1);
		}
		if (matrix[midRow][0] > target) {
			return findRow(matrix, target, startRow, midRow - 1);
		}
		if (matrix[midRow][matrix[0].length - 1] < target) {
			return findRow(matrix, target, midRow + 1, endRow);
		}
		return false;
	}

	private static boolean findCol(int[] nums, int target,
			int startCol, int endCol) {
		if (startCol > endCol) {
			return false;
		}
		int midCol = (startCol + endCol) / 2;
		if (nums[midCol] == target) {
			return true;
		}
		if (nums[midCol] > target) {
			return findCol(nums, target, startCol, midCol - 1);
		}
		if (nums[midCol] < target) {
			return findCol(nums, target, midCol + 1, endCol);
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] m = new int[1][4];
		m[0][0] = 1;
		m[0][1] = 3;
		m[0][2] = 5;
		m[0][3] = 7;
//		m[1][0] = 10;
//		m[1][1] = 11;
//		m[1][2] = 13;
//		m[1][3] = 15;
//		m[2][0] = 17;
//		m[2][1] = 19;
//		m[2][2] = 21;
//		m[2][3] = 23;
//		m[3][0] = 31;
//		m[3][1] = 33;
//		m[3][2] = 41;
//		m[3][3] = 51;
		System.out.println(searchMatrix(m, 1));
	}

}
