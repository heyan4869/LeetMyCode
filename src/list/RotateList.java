// No.61

package list;

public class RotateList {
	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return head;
		}
		ListNode backup = head;
		int len = getLen(backup);
		int num = len - k % len;
		if (k % len == 0) {
			return head;
		}
		ListNode cur = head;
		ListNode pre = head;
		while (num > 1) {
			cur = cur.next;
			num--;
		}
		ListNode temp = cur.next;
		ListNode newHead = temp;
		cur.next = null;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = pre;
		return newHead;
	}

	private static int getLen(ListNode head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		ListNode res = rotateRight(head, 1);
		while (res != null) {
			System.out.print(" - " + res.val + " - ");
			res = res.next;
		}
	}

}
