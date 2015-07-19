// No.2

package list;

public class AddTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode head1 = l1;
		ListNode head2 = l2;
		ListNode fakeHead = new ListNode(Integer.MAX_VALUE);
		ListNode backup = fakeHead;
		int carry = 0;
		while (head1 != null && head2 != null) {
			int temp = head1.val + head2.val + carry;
			ListNode cur = new ListNode(temp % 10);
			backup.next = cur;
			backup = backup.next;
			carry = temp / 10;
			head1 = head1.next;
			head2 = head2.next;
		}
		while (head1 != null) {
			int temp = head1.val + carry;
			ListNode cur = new ListNode(temp % 10);
			backup.next = cur;
			backup = backup.next;
			carry = temp / 10;
			head1 = head1.next;
			// head2 = head2.next;
		}
		
		while (head2 != null) {
			int temp = head2.val + carry;
			ListNode cur = new ListNode(temp % 10);
			backup.next = cur;
			backup = backup.next;
			carry = temp / 10;
			// head1 = head1.next;
			head2 = head2.next;
		}
		
		if (carry != 0) {
			ListNode cur = new ListNode(carry);
			backup.next = cur;
		}
		return fakeHead.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(8);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode res = addTwoNumbers(l1, l2);
		while (res != null) {
			System.out.print(" - " + res.val + " - ");
			res = res.next;
		}
	}

}
