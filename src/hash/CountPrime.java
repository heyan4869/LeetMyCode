// No.204

package hash;

import java.util.*;

public class CountPrime {
	public static int countPrimes(int n) {
		if (n == 1 || n == 2) {
			return 0;
		}
		int odd = n / 2;
		int res = 0;
		boolean[] primes = new boolean[odd];
		// set all odd number to true，2 * n + 3
		for (int i = 0; i < odd; i++) {
			primes[i] = true;
		}
		for (int i = 0; i < odd; i++) {
			int currOdd = 2 * i + 3;
			if (primes[i]) {
				int indexPrime;
				for (int j = 1; (2 * j + 1) * currOdd < n; j++) {
					indexPrime = ((2 * j + 1) * currOdd - 3) / 2;
					primes[indexPrime] = false;
				}
			}
		}
		for (int i = 0; i < odd; i++) {
			if (primes[i])
				res++;
		}
		return res;
	}
	
	// this solution got TLE
	public static int countPrime(int n) {
		if (n <= 2) {
			return n - 1;
		}
		int res = 0;
		Map<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
		for (int i = 2; i < n; i++) {
			if (i % 2 == 0 && i != 2) {
				continue;
			}
			if (!hm.containsKey(i)) {
				res++;
				hm.put(i, true);
				int temp = 2;
				while (temp < n / i) {
					hm.put(temp * i, true);
					temp++;
				}
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes(30));
	}

}
