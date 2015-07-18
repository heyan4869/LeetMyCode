package list;

import java.util.Stack;

public class PalindromeLinkedList {
	public static boolean isPalindrome(ListNode head) {
		Stack<Integer> s = new Stack<Integer>();
		ListNode temp = head;
		ListNode cur = head;
		while (temp != null) {
			s.push(temp.val);
			temp = temp.next;
		}
		while (cur != null) {
			if (cur.val != s.peek())
				return false;
			else {
				cur = cur.next;
				s.pop();
			}
		}
		return true;
	}
	
	// my bit manipulation solution does not work in some test case
	public boolean isPalin(ListNode head) {
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
		// TODO Auto-generated method stub

	}

}
