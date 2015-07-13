// No.92
// little tricky

package list;

public class ReverseLinkedListII {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakehead = new ListNode(0);
		fakehead.next = head;
		ListNode pre = fakehead;
		ListNode curr = head;

		// Move pre and curr to orignal place
		for (int i = 1; i < m; i++) {
			pre = pre.next;
			curr = curr.next;
		}

		for (int i = 0; i < n - m; i++) {
			// Both pre and curr are all fixed, only
			// current is assigned every time to
			// curr.next. curr is pushed back
			// everytime
			ListNode now = curr.next;
			// Move current to the position after pre
			curr.next = now.next;
			now.next = pre.next;
			pre.next = now;
		}

		return fakehead.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
