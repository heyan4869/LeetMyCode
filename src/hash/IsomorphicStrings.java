// No.205

package hash;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	public static boolean isIsomorphic(String s, String t) {
		if (s.length() == 0 && t.length() == 0) {
			return true;
		}
		if (s.length() != t.length()) {
			return false;
		}
		return assist(s, t) && assist(t, s);
	}

	private static boolean assist(String s, String t) {
		Map<Character, Character> hm = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			if (!hm.containsKey(s.charAt(i))) {
				hm.put(s.charAt(i), t.charAt(i));
			} else {
				char temp = hm.get(s.charAt(i));
				if (temp != t.charAt(i)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "a";
		String t = "a";
		System.out.println(isIsomorphic(s, t));
	}

}
