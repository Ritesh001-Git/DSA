public class PartitionEqualSubsetSum{
    public static void main(String[] args) {
        int[] nums={1,5,11,5};
        System.out.println(canPartition(nums));
    }
    public static boolean slove(int[] nums,int target,int idx,int curr1,int curr2){
        if(idx==nums.length) return curr1==curr2;
        // if(curr1>target && curr2>target) return false;

        if(slove(nums,target,idx+1,curr1+nums[idx],curr2)) return true;
        if(slove(nums,target,idx+1,curr1,curr2+nums[idx])) return true;

        return false;
       
    }
    public static boolean canPartition(int[] nums) {
        int target=0;
        for(int i:nums) target+=i;
        return slove(nums,target,0,0,0);
    }
}
