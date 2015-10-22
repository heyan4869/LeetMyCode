package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
	public static boolean wordPattern(String pattern, String str) {
		if (pattern == null || str == null || pattern.length() == 0
				|| str.length() == 0) {
			return false;
		}
		Map<String, String> ht = new HashMap<String, String>();
		Set<String> hs = new HashSet<String>();
		String[] pat = pattern.split("");
		String[] arr = str.split(" ");
		if (pat.length != arr.length) {
			return false;
		}
		for (int i = 0; i < pat.length; i++) {
			if (!ht.containsKey(pat[i])) {
				if (!hs.contains(arr[i])) {
					ht.put(pat[i], arr[i]);
					hs.add(arr[i]);
				} else {
					return false;
				}
			} else {
				if (!arr[i].equals(ht.get(pat[i]))) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
