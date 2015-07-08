// No.83

package twopointers;

public class RemoveDuplicatesFromSortedList {
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode fakeHead = new ListNode(Integer.MAX_VALUE);
		fakeHead.next = head;
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p1 = head;
		ListNode p2 = head.next;
		while (p1 != null && p2 != null) {
			if (p1.val != p2.val) {
				p1 = p2;
				p2 = p2.next;
			} else {
				while (p2 != null && p1.val == p2.val) {
					p2 = p2.next;
				}
				if (p2 != null) {
					p1.next = p2;
					p1 = p2;
					p2 = p2.next;
				} else {
					p1.next = null;
				}
			}
		}
		return fakeHead.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
//		head.next = new ListNode(1);
//		head.next.next = new ListNode(2);
//		head.next.next.next = new ListNode(3);
//		head.next.next.next.next = new ListNode(3);
		ListNode res = deleteDuplicates(head);
		while (res != null) {
			System.out.print(" - " + res.val + " - ");
			res = res.next;
		}

	}

}
