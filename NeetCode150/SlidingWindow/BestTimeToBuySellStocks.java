public class BestTimeToBuySellStocks {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices)); // Output: 5
        System.out.println(maxProfit2(prices)); // Output: 5
    }
    // Two Pointer Approach
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
    // Dynamin Programming Approach
    public static int maxProfit2(int[] prices) {
        int maxProfit=0;
        int minPrice=prices[0];
        for(int i:prices){
            maxProfit=Math.max(maxProfit,i-minPrice);
            minPrice=Math.min(minPrice,i);
        }
        return maxProfit;
    }
}
