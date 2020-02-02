package g1;

/**
 * @Classname Solution121
 * @Description 买卖股票的最佳时机
 * @Date 2019/12/20 10:30
 * @Author SunCheng
 */
public class Solution121 {
    /**
     * 一次遍历
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)return 0;
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                min = Math.min(min, prices[i]);
            } else {
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;
    }

    /**
     * BF
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length < 2)return 0;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <i ; j++) {
                max = Math.max(max,prices[i] - prices[j]);
            }
        }
        return max;
    }
}
