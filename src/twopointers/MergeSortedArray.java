// No.88
// merge nums2 into nums1 as one sorted array

package twopointers;

public class MergeSortedArray {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		if (n == 0) {
			return;
		}
		if (m == 0) {
			for (int i = 0; i < n; i++) {
				nums1[i] = nums2[i];
			}
		}
		int p1 = m - 1;
		int p2 = n - 1;
		int pm = m + n - 1;
		while (p1 >= 0 && p2 >= 0) {
			if (nums1[p1] > nums2[p2]) {
				nums1[pm] = nums1[p1];
				p1--;
				pm--;
			} else {
				nums1[pm] = nums2[p2];
				p2--;
				pm--;
			}
		}
		while (p2 >= 0) {
			nums1[pm] = nums2[p2];
			p2--;
			pm--;
		}
	}

	public static void main(String[] args) {
		int[] nums1 = {2, 0};
		int[] nums2 = {1};
		merge(nums1, 1, nums2, 1);
		for (int i = 0; i < nums1.length; i++) {
			System.out.print(" " + nums1[i] + " ");
		}
	}

}
