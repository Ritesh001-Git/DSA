public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        System.out.print("Product of array except self: ");
        for (int num : result) {
            System.out.print(num + " "); // Output: 24 12 8 6
        }
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] pre=new int[nums.length];
        pre[0]=1;
        for(int i=1; i<nums.length; i++){
            pre[i]=nums[i-1]*pre[i-1];
        }
        int r=1;
        for(int i=nums.length-1; i>=0; i--){
            pre[i]*=r;
            r*=nums[i];
        }
        return pre;
    }
}
