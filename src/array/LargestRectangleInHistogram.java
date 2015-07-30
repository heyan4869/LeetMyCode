// No.84
// confused

package array;

import java.util.*;

public class LargestRectangleInHistogram {
	public static int largestRectangleArea(int[] height) {
		// add one 0 to the end of array
		height = Arrays.copyOf(height, height.length + 1);

		int maxRect = 0;
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < height.length; ++i) {
			while (!st.isEmpty() && height[i] < height[st.peek()]) {
				int rect = height[st.pop()]
						* (st.isEmpty() ? i : (i - st.peek() - 1));
				maxRect = Math.max(maxRect, rect);
			}
			st.push(i);
		}

		return maxRect;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
