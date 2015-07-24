// No.42
// confused

package twopointers;

public class TrappingRainWater {
	public static int trap(int[] height) {
		int l = 0, r = height.length - 1, water = 0, minHeight = 0;
		while (l < r) {
			while (l < r && height[l] <= minHeight)
				water += minHeight - height[l++];
			while (r > l && height[r] <= minHeight)
				water += minHeight - height[r--];
			minHeight = Math.min(height[l], height[r]);
		}
		return water;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
