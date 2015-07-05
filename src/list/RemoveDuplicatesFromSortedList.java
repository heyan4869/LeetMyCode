package list;

public class RemoveDuplicatesFromSortedList {
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode fakeHead = new ListNode(Integer.MAX_VALUE);
		fakeHead.next = head;
		
		
		return fakeHead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
