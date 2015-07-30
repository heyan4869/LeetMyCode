// No.23

package list;

public class MergeKSortedList {
	public ListNode mergeKLists(ListNode[] lists) {
		int len = lists.length;
		if (len == 0) {
			return null;
		}
		if (len == 1) {
			return lists[0];
		}
		while (len > 1) {
			for (int i = 0; i < len / 2; i++) {
				lists[i] = mergeTwoList(lists[i], lists[len - 1 - i]);
			}
			len = (len / 2 + len % 2);
		}
		return lists[0];
	}

	public ListNode mergeTwoList(ListNode a, ListNode b) {
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		if (a.val < b.val) {
			a.next = mergeTwoList(a.next, b);
			return a;
		} else {
			b.next = mergeTwoList(a, b.next);
			return b;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
