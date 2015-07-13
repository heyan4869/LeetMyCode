// No.25
// get to know PriorityQueue

package divideconquer;

import java.util.PriorityQueue;

public class KthLargestInArray {
	public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
		for (int i = 0; i < nums.length; i++) {
			if (queue.size() < k)
				queue.add(nums[i]);
			else {
				if (nums[i] > queue.peek()) {
					queue.remove();
					queue.add(nums[i]);
				}
			}
		}
		return queue.remove();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
