// No.200

package dfs;

public class NumberOfIslands {
	public static int numIslands(char[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		if (row == 0) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1') {
					marking(grid, i, j, row, col);
					++count;
				}
			}
		}
		return count;
	}
	
	private static void marking(char[][] grid, int i, int j, int row, int col) {
		if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1') {
			return;
		}
		grid[i][j] = '0';
		marking(grid, i + 1, j, row, col);
		marking(grid, i - 1, j, row, col);
		marking(grid, i, j + 1, row, col);
		marking(grid, i, j - 1, row, col);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
