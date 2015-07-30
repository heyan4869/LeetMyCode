// No.147
// tricky

package list;

public class InsertionSortList {
	public static ListNode insertionSortList(ListNode head) {
		ListNode curr = head;
		ListNode next = null;
		ListNode fakeHead = new ListNode(0);
		while (curr != null) {
			next = curr.next;
			ListNode p = fakeHead;
			while (p.next != null && p.next.val < curr.val) {
				p = p.next;
			}
			// insert curr between p and p.next
			curr.next = p.next;
			p.next = curr;
			curr = next;
		}
		return fakeHead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
