// No.203

package list;

public class RemoveLinkedListElements {
	public static ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		ListNode fakeHead = new ListNode(Integer.MAX_VALUE);
		fakeHead.next = head;
		ListNode p1 = fakeHead;
		ListNode p2 = p1;
		while (p1.next != null) {
			if (p1.next.val == val) {
				p2 = p1.next;
				while (p2 != null && p2.val == val) {
					p2 = p2.next;
				}
				if (p2 == null) {
					p1.next = null;
					return fakeHead.next;
				} else {
					p1.next = p2;
					p1 = p1.next;
				}
			} else {
				p1 = p1.next;
				p2 = p1;
			}
		}
		
		return fakeHead.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(6);
		ListNode res = removeElements(head, 1);
		while (res != null) {
			System.out.print(" - " + res.val + " - ");
			res = res.next;
		}

	}

}
