package slidingwindow;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int wS = 0, wE = 1;
        int n = prices.length;
        int max = 0;
        while (wE < n) {
            if (prices[wE] > prices[wS]) {
                max = Math.max(max, prices[wE] - prices[wS]);
            } else {
                wS = prices[wS] < prices[wE] ? wS : wE;
            }
            wE++;
        }
        return max;
    }

    // Another simple way
    public int maxProfit2(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock b= new BestTimeToBuyAndSellStock();
        int[] arr = {7,1,5,3,6,4};
        System.out.println(b.maxProfit(arr));
    }
}
