// No.141

package twopointers;

public class LinkedListCycle {
	// Using fast runner pointer
	public static boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode p1 = head;
		ListNode p2 = head;
		while (p1 != null && p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(4);
		head.next.next = new ListNode(2);
		// head.next.next.next = head;
		System.out.println(hasCycle(head));

	}

}
