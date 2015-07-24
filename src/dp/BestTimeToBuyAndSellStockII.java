// No.122

package dp;

public class BestTimeToBuyAndSellStockII {
	// only permitted sell before buy
	public static int maxProfit(int[] prices) {
		int res = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i + 1] > prices[i])
				res += prices[i + 1] - prices[i];
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
