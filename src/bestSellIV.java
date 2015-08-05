public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0 || prices == null || k<=0)
          return 0;
        if(k>prices.length/2){
            int res = 0;

            for (int i = 1; i < prices.length; ++i) {
            if (prices[i] - prices[i - 1] > 0) {
                res += prices[i] - prices[i - 1];
            }
        }
            return res;
        }
        else{
            int local [] = new int[k+1];
            int global [] = new int[k+1];
            local[0] = 0;
            local[0] = 0;
            for(int i = 0;i<prices.length-1;i++){
                int gap = prices[i+1]-prices[i];
                for(int j = k;j>=1;j--){
                    local[j] = Math.max(global[j-1]+Math.max(gap,0),local[j]+gap);
                    global[j] = Math.max(local[j],global[j]);
                }
            }
            return global[k];
        }
        
    }
}