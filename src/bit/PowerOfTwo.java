// No.231

package bit;

public class PowerOfTwo {
	public static boolean isPowerOfTwo(int n) {
		if (n < 0) {
			return false;
		}
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & 1) == 1) {
				count++;
			}
			n = n >> 1;
		}
		if (count == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(-2147483646));
	}

}
