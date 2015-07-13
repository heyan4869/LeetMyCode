// No.19

package twopointers;

public class RemoveNthNodeFromEndOfList {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		ListNode p1 = head;
		ListNode p2 = head;
		while (n > 0 && p2 != null) {
			p2 = p2.next;
			n--;
		}
		if (p2 == null) {
			return head.next;
		}
		while (p2.next != null) {
			p2 = p2.next;
			p1 = p1.next;
		}
		ListNode temp = p1.next.next;
		p1.next = temp;
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		//head.next.next = new ListNode(3);
		//head.next.next.next = new ListNode(4);
		ListNode res = removeNthFromEnd(head, 2);
		while (res != null) {
			System.out.print(" - " + res.val + " - ");
			res = res.next;
		}
	}

}
