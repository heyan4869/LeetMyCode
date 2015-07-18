// No.143

package list;

import java.util.*;

public class ReorderList {
	public static void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}
		ListNode backup = head;
		ListNode temphead = head;
		Stack<ListNode> st = new Stack<ListNode>();
		while (backup != null) {
			st.push(backup);
			backup = backup.next;
		}
		int num = (st.size() - 1) / 2;
		while (num > 0) {
			ListNode temp = temphead.next;
			ListNode tail = st.pop();
			temphead.next = tail;
			tail.next = temp;
			temphead = temp;
			num--;
		}
		st.pop().next = null;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		reorderList(head);
		while (head != null) {
			System.out.print(" - " + head.val + " - ");
			head = head.next;
		}
	}

}
