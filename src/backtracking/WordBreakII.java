// No.140

package backtracking;

import java.util.*;

public class WordBreakII {
	// recursion
	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> res = new ArrayList<String>();
		// this checking step is the key point to reduce time
		for (int j = s.length() - 1; j >= 0; j--) {
			if (wordDict.contains(s.substring(j))) {
				break;
			} else {
				if (j == 0)
					return res;
			}
		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (wordDict.contains(s.substring(0, i + 1))) {
				List<String> strs = wordBreak(s.substring(i + 1, s.length()),
						wordDict);
				if (strs.size() != 0) {
					// use Iterator
					for (Iterator<String> it = strs.iterator(); it.hasNext();) {
						res.add(s.substring(0, i + 1) + " " + it.next());
					}
				}
			}
		}
		if (wordDict.contains(s))
			res.add(s);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
