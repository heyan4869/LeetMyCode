// No.187
// tricky

package hash;

import java.util.*;

public class RepeatedDNASequences {
	// use bit manipulation
	public static List<String> findRepeatedDnaSequences(String s) {
		Set<Integer> words = new HashSet<>();
		Set<Integer> doubleWords = new HashSet<>();
		List<String> res = new ArrayList<>();
		char[] map = new char[26];
		// map['A' - 'A'] = 0;
		map['C' - 'A'] = 1;
		map['G' - 'A'] = 2;
		map['T' - 'A'] = 3;

		for (int i = 0; i < s.length() - 9; i++) {
			int v = 0;
			for (int j = i; j < i + 10; j++) {
				v <<= 2;
				v |= map[s.charAt(j) - 'A'];
			}
			if (!words.add(v) && doubleWords.add(v)) {
				res.add(s.substring(i, i + 10));
			}
		}
		return res;
	}

	// this straight forward solution got MLE
	public static List<String> findRepeatedDna(String s) {
		List<String> res = new ArrayList<String>();
		if (s.length() < 10) {
			return res;
		}
		Map<String, Integer> hm = new HashMap<String, Integer>();
		for (int i = 0; i < s.length() - 10; i++) {
			String temp = s.substring(i, i + 10);
			if (!hm.containsKey(temp)) {
				hm.put(temp, i);
			} else {
				if (!res.contains(temp)) {
					res.add(temp);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		List<String> res = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}

}
