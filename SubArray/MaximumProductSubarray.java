public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums={2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[]nums){
        int max=Integer.MIN_VALUE;
        int p=1;
        for(int i=0; i<nums.length; i++){
            p*=nums[i];
            max=Math.max(p,max);
            if(p==0) p=1;
        }
        p=1;
        for(int i=nums.length-1; i>=0; i--){
            p*=nums[i];
            max=Math.max(p,max);
            if(p==0) p=1;
        }
        return max;
    }
}
