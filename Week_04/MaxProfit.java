/**
 * 122.买股票的最佳时机 II
 *
 * @author Q
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices1={7,1,5,3,6,4};
        int[] prices2={1,2,3,4,5};
        int[] prices3={7,6,4,3,1};
        int[] prices4={7,7,7,7,7};
        System.out.println(maxProfit(prices3));
    }

    /**
     * 贪心算法
     * 时间复杂度：O(n) 空间复杂度:O(1)
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices){
        int maxProfit=0;
        for (int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                maxProfit+=prices[i]-prices[i-1];
            }
        }
        return maxProfit;
    }

}
