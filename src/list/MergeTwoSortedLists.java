// No.21

package list;

public class MergeTwoSortedLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		} else if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}
		
		ListNode fakeHead = new ListNode(Integer.MAX_VALUE);
		ListNode backup = fakeHead;
		ListNode p1 = l1;
		ListNode p2 = l2;
		if (p1.val <= p2.val) {
			fakeHead.next = p1;
			backup = p1;
			p1 = p1.next;
		} else {
			fakeHead.next = p2;
			backup = p2;
			p2 = p2.next;
		}
		
		while(p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				backup.next = p1;
				backup = backup.next;
				p1 = p1.next;
			} else {
				backup.next = p2;
				backup = backup.next;
				p2 = p2.next;
			}
		}
		if (p1 != null) {
			backup.next = p1;
		} else if (p2 != null) {
			backup.next = p2;
		}
		
		return fakeHead.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
//		l1.next = new ListNode(3);
//		l1.next.next = new ListNode(8);
//		l2.next = new ListNode(6);
		ListNode res = mergeTwoLists(l1, l2);
		while (res != null) {
			System.out.print(" " + res.val + " ");
			res = res.next;
		}
	}

}
