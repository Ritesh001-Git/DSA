import java.util.*;
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr={5,8,3,7,9,1};
        System.out.println(lis(arr));
    }
    public static int lis(int[] arr){
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int max=0;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;

    }
}
