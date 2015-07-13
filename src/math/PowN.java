// No.50
// tricky

package math;

public class PowN {
	public static double myPow(double x, int n) {
		if (n > 0)
			return myPowInner(x, n);
		else
			return 1.0 / myPowInner(x, -n);
	}

	public static double myPowInner(double x, int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		double inter = myPowInner(x, n / 2);
		if (n % 2 == 1)
			return inter * inter * x;
		else
			return inter * inter;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
