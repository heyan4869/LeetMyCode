// No.69

package binarysearch;

public class SqrtX {
	public static int mySqrt(int x) {
		if (x == 0) {
			return 0;
		}
		int left = 1, right = x, res = 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (mid > x / mid) {
				right = mid;
			} else {
				res = mid;
				left = mid + 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
