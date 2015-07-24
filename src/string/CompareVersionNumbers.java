// No.165

package string;

public class CompareVersionNumbers {
	public static int compareVersion(String version1, String version2) {
		// special char "."
		String[] v1 = version1.split("[.]");
		String[] v2 = version2.split("[.]");
		int i = 0;
		while (i < v1.length || i < v2.length) {
			String temp1;
			String temp2;
			if (i < v1.length) {
				temp1 = v1[i];
			} else {
				temp1 = "0";
			}
			if (i < v2.length) {
				temp2 = v2[i];
			} else {
				temp2 = "0";
			}
			
			if (Integer.parseInt(temp1) > Integer.parseInt(temp2)) {
				return 1;
			} else if (Integer.parseInt(temp1) < Integer.parseInt(temp2)) {
				return -1;
			} else {
				i++;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		String version1 = "1.2.1.3";
		String version2 = "1.2.1";
		System.out.println(compareVersion(version1, version2));
	}

}
