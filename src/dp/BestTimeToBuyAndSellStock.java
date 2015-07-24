// No.121

package dp;

public class BestTimeToBuyAndSellStock {
	// only permitted to complete at most one transaction
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(prices[i], min);
			max = Math.max(max, prices[i] - min);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] prices = {2, 1};
		System.out.println(maxProfit(prices));
	}

}
