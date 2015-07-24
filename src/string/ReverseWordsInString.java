// No.151

package string;

public class ReverseWordsInString {
	public static String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		// only consider non-space elements
		String[] sarray = s.split(" ");
		String res = "";
		for (int i = sarray.length - 1; i >= 0; i--) {
			if (sarray[i].equals(" ") || sarray[i].equals("")) {
				continue;
			} else {
				res += " " + sarray[i];
			}
		}
		if (res.length() == 0) {
			return res;
		} else {
			return res.substring(1);
		}
	}

	public static void main(String[] args) {
		String s = " ";
		System.out.println(reverseWords(s));
	}

}
