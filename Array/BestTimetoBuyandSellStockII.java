public class BestTimetoBuyandSellStockII {
    public static void main(String[] args) {
        int[] prices={1,2,3,4,5,6,7,8,9};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int max=0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]>prices[i-1]) max+=(prices[i]-prices[i-1]);
        }
        return max;
    }
}
