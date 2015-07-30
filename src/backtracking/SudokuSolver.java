// No.37

package backtracking;

public class SudokuSolver {
	public static void solveSudoku(char[][] board) {
		if (board.length == 0 || board == null) {
			return;
		}
		assist(board);
	}

	private static boolean assist(char[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col] == '.') {
					for (char cur = '1'; cur <= '9'; cur++) {
						// check each row, column, square
						if (check(board, row, col, cur)) {
							board[row][col] = cur;
							if (assist(board)) {
								return true;
							} else {
								board[row][col] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private static boolean check(char[][] board, int row, int col, char cur) {
		// check row
		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == cur) {
				return false;
			}
		}
		// check col
		for (int j = 0; j < board[0].length; j++) {
			if (board[row][j] == cur) {
				return false;
			}
		}
		// check square
		int numr = row / 3;
		int numc = col / 3;
		for (int i = 3 * numr; i < 3 * numr + 3; i++) {
			for (int j = 3 * numc; j < 3 * numc + 3; j++) {
				if (board[i][j] == cur) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
