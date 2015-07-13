// No.58

package string;

public class LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int end = s.length() - 1;
		while (end >= 0) {
			if (s.charAt(end) != ' ') {
				break;
			}
			end--;
		}
		if (end < 0) {
			return 0;
		} else if (end == 0) {
			return 1;
		} else {
			int head = end - 1;
			while (head >= 0) {
				if (s.charAt(head) == ' ') {
					break;
				}
				head--;
			}
			return end - head;
		}
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord(" www  world   "));
	}

}
