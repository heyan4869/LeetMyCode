// No.3
// tricky

// every time add the "end" char into the HashSet and move it to 
// the next element in the array. If the "end" char is the duplicate 
// one, update the "max" first, and then start to remove the "start"
// element in the hashset until the duplicate char has been removed.
package twopointers;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		if (s.length() < 2) {
			return s.length();
		}
		int len = s.length();
		char[] array = s.toCharArray();
		int start = 0, end = 0, maxLen = 1;
		Set<Character> hs = new HashSet<Character>();
		while (end < len) {
			if (!hs.add(array[end])) {
				if ((end - start) > maxLen)
					maxLen = end - start;
				while (!hs.add(array[end])) {
					hs.remove(array[start]);
					start++;
				}
			}
			end = end + 1;
		}
		return maxLen > (end - start) ? maxLen : (end - start);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
