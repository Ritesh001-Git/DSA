public class MaximumSumSizeK {
    public static void main(String[] args) {
        int[] arr = {0, 1, 5, 1, 3, 44};
        int k = 3;
        System.out.println(maxSum(arr, k));
    }
    public static int maxSum(int[] arr,int k){
        int max=Integer.MIN_VALUE;
        int sum=0;
        for (int i = 0; i < k; i++) {
            sum+=arr[i];
        }
        max=Math.max(max, sum);
        for(int i=k; i<arr.length; i++){
            sum+=(arr[i]-arr[i-k]);
            max=Math.max(sum,max);
        }
        return max;
    }
}
