public class CheckIfAll1sAreatLeastLengthKPlacesAway {
    public static void main(String[] args) {
        int[] nums={0,0,1,0,0,1,0,0,0,1,0};
        System.out.println(kLengthApart(nums,2));
    }
    public static boolean kLengthApart(int[] nums, int k) {
        int prev=0;
        while(prev<nums.length && nums[prev]!=1) prev++;
        for(int i=prev+1; i<nums.length; i++){
            if(nums[i]==1){
                if(i-prev-1<k) return false;
                prev=i;
            }
        }
        return true;
    }
}
