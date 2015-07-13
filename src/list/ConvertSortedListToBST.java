// No.109

package list;

import java.util.ArrayList;
import java.util.List;

import list.TreeNode;

public class ConvertSortedListToBST {
	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		int len = getLen(head);
		return assist(head, 0, len - 1);
		
	}
	
	private static TreeNode assist(ListNode head, int start, int end) {
		if (start > end) {
			return null;
		}
		ListNode backup = head;
		int mid = (start + end) / 2;
		int i = mid;
		while (i > 0) {
			backup = backup.next;
			i--;
		}
		TreeNode root = new TreeNode(backup.val);
		root.left = assist(head, start, mid - 1);
		// this got TLE first, has fixed
		// root.right = assist(head, mid + 1, end);
		root.right = assist(backup.next, 0, end - mid - 1);
		return root;
	}

	private static int getLen(ListNode head) {
		int len = 0;
		ListNode backup = head;
		while (backup != null) {
			len++;
			backup = backup.next;
		}
		return len;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		// System.out.println(getLen(head));
		TreeNode root = sortedListToBST(head);
		List<Integer> res = inorderTraversal(root);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(" " + res.get(i) + " ");
		}
	}
	
	// use inorder traversal to check result
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		assist(root, res);
		return res;
	}

	private static void assist(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		assist(root.left, res);
		res.add(root.val);
		assist(root.right, res);
	}

}
