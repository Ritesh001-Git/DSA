public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums={-2,0,-1};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[]nums){
        int max=Integer.MIN_VALUE;
        int p=1;
        for(int i:nums){
            p*=i;
            max=Math.max(p,max);
            if(p==0) p=1;
        }
        for(int i=nums.length-1; i>=0; i--){
            p*=nums[i];
            max=Math.max(p,max);
            if(p==0) p=1;
        }
        return max;
    }
}
