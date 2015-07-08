// No.11

package twopointers;

public class ContainerWithMostWater {
	public static int maxArea(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
		int maxWater = 0;
		int p1 = 0;
		int p2 = height.length - 1;
		while (p1 < p2) {
			int tempWater = Math.min(height[p1], height[p2]) * (p2 - p1);
			maxWater = Math.max(maxWater, tempWater);
			if (height[p1] >= height[p2]) {
				p2--;
			} else {
				p1++;
			}
		}
		return maxWater;
	}

	public static void main(String[] args) {
		int[] height = {2, 1, 3, 2};
		System.out.println(maxArea(height));
	}

}
