// No.13
// tricky

package math;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public static int romanToInt(String s) {
		Map<Character, Integer> roman = new HashMap<Character, Integer>();
		roman.put('I', 1);
		roman.put('V', 5);
		roman.put('X', 10);
		roman.put('L', 50);
		roman.put('C', 100);
		roman.put('D', 500);
		roman.put('M', 1000);

		int res = 0;
		char prev = '#';
		for (int i = s.length() - 1; i >= 0; i--) {
			char curr = s.charAt(i);
			int val = roman.get(curr);
			if (val < res && curr != prev) {
				res = res - val;
			} else {
				res = res + val;
			}
			prev = curr;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
