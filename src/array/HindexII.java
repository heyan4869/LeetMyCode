package array;

public class HindexII {
	public static int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}
		return assist(citations, 0, citations.length - 1);
	}

	private static int assist(int[] citations, int head, int tail) {
		if (head > tail) {
			return 0;
		}
		int mid = head + (tail - head) / 2;
		if (citations[mid] >= citations.length - mid && (mid == 0 || citations[mid - 1] < citations.length - mid + 1)) {
			return citations.length - mid;
		} else if (citations[mid] >= citations.length - mid && citations[mid - 1] >= citations.length - mid + 1) {
			return assist(citations, head, mid - 1);
		} else {
			return assist(citations, mid + 1, tail);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = new int[]{ 100, 2 };
		System.out.println(hIndex(citations));
	}

}
