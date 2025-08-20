public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
    public static int maxSubArray(int[] nums) {
        int max=0;
        int sum=0;
        for(int i:nums){
            sum+=i;
            max=Math.max(max,sum);
            if(sum<0) sum=0;
        }
        return max;
    }
}
