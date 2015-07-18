// No.237

package list;

public class DeleteNodeInLinkedList {
	public static void deleteNode(ListNode node) {
		if (node == null) {
			return;
		}
		ListNode temp = node.next;
		while (temp != null) {
			node.val = temp.val;
			temp = temp.next;
			if (temp != null) {
				node = node.next;
			} else {
				node.next = null;
				break;
			}
		}
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		deleteNode(head.next.next);
		while (head != null) {
			System.out.print(" " + head.val + " ");
			head = head.next;
		}
	}

}
