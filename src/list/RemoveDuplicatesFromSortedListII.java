// No.82

package list;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedListII {
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fakeHead = new ListNode(Integer.MAX_VALUE);
		fakeHead.next = head;
		ListNode p1 = fakeHead;
		ListNode p2 = head;
		Set<Integer> hs = new HashSet<Integer>();
		while (p2 != null) {
			ListNode temp = findNext(p2, hs);
			p1.next = temp;
			p1 = temp;
			if (temp != null) {
				p2 = temp.next;
			} else {
				p2 = null;
			}
		}
		return fakeHead.next;
	}
	
	// this situation is quite complicate
	private static ListNode findNext(ListNode p2, Set<Integer> hs) {
		if (p2.next == null && !hs.contains(p2.val)) {
			hs.add(p2.val);
			return p2;
		} else if (p2.next == null && hs.contains(p2.val)) {
			return null;
		} else if (p2.next != null && p2.next.val != p2.val
				&& !hs.contains(p2.val)) {
			hs.add(p2.val);
			return p2;
		} else if (p2.next != null && p2.next.val != p2.val
				&& hs.contains(p2.val)) {
			return findNext(p2.next, hs);
		} else if (p2.next != null && p2.next.val == p2.val
				&& hs.contains(p2.val)) {
			p2 = p2.next;
			return findNext(p2, hs);
		} else if (p2.next != null && p2.next.val == p2.val
				&& !hs.contains(p2.val)) {
			hs.add(p2.val);
			p2 = p2.next;
			return findNext(p2, hs);
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = new ListNode(5);
		ListNode res = deleteDuplicates(head);
		while (res != null) {
			System.out.print(" - " + res.val + " - ");
			res = res.next;
		}
	}

}
