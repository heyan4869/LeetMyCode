// No.48
// in place, a little tricky

package array;

public class RotateImage {
	public static void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i) {
				int diff = i - first;
				// save the top
				int top = matrix[first][i];

				// left -> top
				matrix[first][i] = matrix[last - diff][first];

				// bottom -> left
				matrix[last - diff][first] = matrix[last][last - diff];

				// right -> bottom
				matrix[last][last - diff] = matrix[i][last];

				// top -> right
				matrix[i][last] = top;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
