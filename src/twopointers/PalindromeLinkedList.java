// No.234
// confused

package twopointers;

import twopointers.ListNode;

public class PalindromeLinkedList {
	// reference solution
	public static boolean isPalindrome(ListNode head) {
		ListNode cur = head;
		int len = 0;
		while (cur != null) {
			cur = cur.next;
			len++;
		}
		if (len < 2)
			return true;
		// reverse
		cur = head.next;
		ListNode base = head;
		head.next = null;
		for (int i = 0; i < len / 2 - 1; i++) {
			ListNode tmp = cur.next;
			cur.next = base;
			base = cur;
			cur = tmp;
		}
		// compare
		if (len % 2 == 1)
			cur = cur.next;
		for (int i = 0; i < len / 2; i++) {
			if (base.val != cur.val)
				return false;
			base = base.next;
			cur = cur.next;
		}
		return true;
	}

	// this solution got wrong answer
	public static boolean isPalin(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		int len = getLen(head);
		int res = 0;
		ListNode backup = head;
		if (len % 2 == 0) {
			while (backup != null) {
				res = res ^ backup.val;
				backup = backup.next;
			}
			if (res == 0) {
				return true;
			} else {
				return false;
			}
		} else {
			int count = 0;
			while (backup != null) {
				if (count == len / 2) {
					backup = backup.next;
				}
				res = res ^ backup.val;
				backup = backup.next;
				count++;
			}
			if (res == 0) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static int getLen(ListNode node) {
		int len = 0;
		while (node != null) {
			len++;
			node = node.next;
		}
		return len;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(1);
		System.out.println(isPalindrome(head));
	}

}
