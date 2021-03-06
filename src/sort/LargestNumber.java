// No.179
// tricky, comparator

package sort;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
			return "";
		String[] strnum = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strnum[i] = nums[i] + "";
		}
		
		// use the comparator interface is important
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s1.compareTo(s2);
			}
		};

		// use comp to sort the strnum array
		Arrays.sort(strnum, comp);
		if (strnum[strnum.length - 1].charAt(0) == '0')
			return "0";
		StringBuilder sb = new StringBuilder();
		for (String s : strnum) {
			sb.insert(0, s);
		}
		return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
