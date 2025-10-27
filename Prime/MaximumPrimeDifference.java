public class MaximumPrimeDifference {
    public static void main(String[] args) {
        int[] nums = {4, 6, 8, 10, 11, 14, 15, 17, 18};
        int result = maximumPrimeDifference(nums);
        System.out.println("Maximum Prime Difference: " + result);
    }
    public static boolean isPrime(int n){
        if(n<=1) return false;
        if(n==2 || n==3) return true;
        if(n%2==0 || n%3==0){
            return false;
        }
        for(int i=5; i*i<=n; i++){
            if(n%i==0 || n%(i+2)==0)return false;
        }
        return true;
    }
    public static int maximumPrimeDifference(int[] nums) {
        int i;
        int j;
        for(i=0; i<nums.length; i++){
            if(isPrime(nums[i])) break;
        }
        for(j=nums.length-1; j>=0; j--){
            if(isPrime(nums[j])) break;
        }
        return Math.abs(j-i);
    }
}
