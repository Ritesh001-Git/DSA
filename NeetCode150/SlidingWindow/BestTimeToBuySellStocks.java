public class BestTimeToBuySellStocks {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices)); // Output: 5
    }
    public static int maxProfit(int[] prices) {
        int l=0,r=1;
        int maxProfit=0;
        while(r<prices.length){
            if(prices[l]<prices[r]){
                int profit=prices[r]-prices[l];
                maxProfit=Math.max(maxProfit,profit);
            }else{
                l=r;
            }
            r++;
        }
        return maxProfit;
    }
}
