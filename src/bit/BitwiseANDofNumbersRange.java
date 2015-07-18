// No.201
// tricky

package bit;

public class BitwiseANDofNumbersRange {
	// AND operation extract the left most consecutive common part of m and n.
	// So keep right shift until they are equal, which means it reaches the 
	// left most consecutive common part.
	public static int rangeBitwiseAnd(int m, int n) {
        int count = 0;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			count++;
		}
		return m <<= count;
    }

	public static void main(String[] args) {
		// 5: 0101
		// 6: 0110
		// 7: 0111
		System.out.println(rangeBitwiseAnd(5, 7));
	}

}
