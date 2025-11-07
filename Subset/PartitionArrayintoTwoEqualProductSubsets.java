public class PartitionArrayintoTwoEqualProductSubsets {
    public static void main(String[] args) {
        int[] nums={3,1,6,8,4};
        long target=24;
        System.out.println(checkEqualPartitions(nums,target));
    }
    public static boolean checkEqualPartitions(int[] nums,long target){
        return slove(nums,0,1,1,target);
    }
    public static boolean slove(int[] nums,int idx,long curr1,long curr2,long target){
        if(idx==nums.length) return curr1==target && curr2==target;
        if(curr1>target || curr2>target) return false;

        if(slove(nums,idx+1,curr1*nums[idx],curr2,target)) return true;
        if(slove(nums,idx+1,curr1,curr2*nums[idx],target)) return true;

        return false;
    }
}
