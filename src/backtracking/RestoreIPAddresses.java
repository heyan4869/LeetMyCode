// No.93

package backtracking;

import java.util.*;

public class RestoreIPAddresses {
	public static List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		if (s.length() < 4 || s.length() > 12) {
			return res;
		}
		String temp = "";
		assist(s, res, temp, 0, 0);
		return res;
	}

	private static void assist(String s, List<String> res, String temp,
			int start, int num) {
		if (num == 4 && temp.length() - 1 == s.length() + 3) {
			temp = temp.substring(0, temp.length() - 1);
			res.add(new String(temp));
			return;
		}
		for (int i = start; i <= s.length(); i++) {
			String cur = s.substring(start, i);
			if (cur.length() >= 1
					&& cur.length() <= 3
					&& Integer.parseInt(cur) >= 0
					&& Integer.parseInt(cur) <= 255
					&& ((cur.charAt(0) == '0' && Integer.parseInt(cur) == 0 
					&& cur.length() == 1) || (cur.charAt(0) != '0' && Integer.parseInt(cur) > 0))) {
				temp = temp + cur + ".";
				assist(s, res, temp, i, num + 1);
				temp = temp.substring(0, temp.length() - cur.length() - 1);
			}
		}
	}

	public static void main(String[] args) {
		String s = "0000";
		List<String> res = restoreIpAddresses(s);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}

}
