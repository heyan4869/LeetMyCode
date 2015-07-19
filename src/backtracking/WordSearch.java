// No.79

package backtracking;

public class WordSearch {
	public static boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++) {
				if (helper(board, i, j, word, 0))
					return true;
			}
		return false;
	}

	private static boolean helper(char[][] board, int i, int j, String word,
			int count) {
		if (count == word.length()) {
			return true;
		}
		if (i > board.length - 1 || i < 0 || j < 0 || j > board[0].length - 1
				|| board[i][j] != word.charAt(count)) {
			return false;
		}
		board[i][j] = '*';
		boolean result = helper(board, i - 1, j, word, count + 1)
				|| helper(board, i, j - 1, word, count + 1)
				|| helper(board, i, j + 1, word, count + 1)
				|| helper(board, i + 1, j, word, count + 1);
		board[i][j] = word.charAt(count);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
