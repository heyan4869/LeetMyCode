// No.160
// get the length and start at same distance to the end

package list;

import list.ListNode;

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		int lenA = getLen(headA);
		int lenB = getLen(headB);
		if (lenA > lenB) {
			while (lenA > lenB) {
				headA = headA.next;
				lenA--;
			}
		} else {
			while (lenA < lenB) {
				headB = headB.next;
				lenB--;
			}
		}

		while (headA != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}

		return null;
	}

	public int getLen(ListNode node) {
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
