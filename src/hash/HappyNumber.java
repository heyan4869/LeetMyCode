// No.202

package hash;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public static boolean isHappy(int n) {
        if (n <= 0) {
        	return false;
        }
        Set<Integer> hs = new HashSet<Integer>();
    	return assist(n, hs);
    }
    
    public static boolean assist(int n, Set<Integer> hs) {
		if (n == 1) {
			return true;
		}
		if (hs.contains(n)) {
			return false;
		} else {
			int sum = 0;
			int backup = n;
			while (n != 0) {
				int temp = n % 10;
				sum = sum + temp * temp;
				n = n / 10;
			}
			if (sum == 1) {
				return true;
			} else {
				hs.add(backup);
				n = sum;
				return assist(n, hs);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}

}
