package array;

import java.util.Arrays;

public class Hindex {
	public static int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}
		Arrays.sort(citations);
		int hin = 0;
		int len = citations.length;
		for (int i = 0; i < len; i++) {
			if (citations[i] >= len - i) {
				hin = len - i;
				i = len;
			}
		}
		return hin;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = new int[]{100, 2};
		System.out.println(hIndex(citations));
	}

}
