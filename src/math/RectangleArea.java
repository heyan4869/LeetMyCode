// No.223

package math;

public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int overlap;
		if (C <= E || A >= G || B >= H || D <= F) {
			overlap = 0;
		} else {
			int x = Math.min(C, G) - Math.max(A, E);
			int y = Math.min(D, H) - Math.max(B, F);
			overlap = x * y;
		}
		return (C - A) * (D - B) + (G - E) * (H - F) - overlap;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
