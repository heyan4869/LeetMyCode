// No.190

package bit;

public class ReverseBits {
	public static int reverseBits(int n) {
		long sum = 0;
		for (int i = 0; i < 32; i++) {
			sum += Math.pow(2, 31 - i) * (n & 1);
			n = n >> 1;
		}
		return (int) sum;
	}
	
	
	// mine fails
	public static int reverseBit(int n) {
		for (int i = 0; i < 16; i++) {
			int low = (int) Math.pow(2, i) & n;
			int high = (int) Math.pow(2, 31 - i) & n;
			if (low != high) {
				n = n ^ (int) Math.pow(2, i);
				n = n ^ (int) Math.pow(2, 31 - i);
			}
		}
		return n;
	}

	public static void main(String[] args) {
		System.out.println(reverseBits(43261596));
		// int i = 4;
		// int j = 43261596 ^ (i << 27);
		// System.out.println(j);
	}
}
