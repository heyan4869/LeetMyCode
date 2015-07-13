// No.138

package list;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
	public static RandomListNode copyRandomList(RandomListNode head) {
		// no need to check this
		// if (head == null || head.next == null) {
		// return head;
		// }
		Map<RandomListNode, RandomListNode> hm = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode backup = head;
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode fake = dummy;

		while (backup != null) {
			hm.put(backup, backup.random);
			backup = backup.next;
		}
		while (head != null) {
			dummy.next = new RandomListNode(head.label);
			RandomListNode temp = hm.get(head);
			if (temp == null) {
				dummy.next.random = null;
			} else {
				dummy.next.random = new RandomListNode(temp.label);
			}
			dummy = dummy.next;
			head = head.next;
		}
		return fake.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
