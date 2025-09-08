public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int index = searchInsert(nums, target);
        System.out.println("Index of target " + target + ": " + index); // Output: 2
    }
    public static  int searchInsert(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while(i<=j){
            int m=(i+j)/2;
            if(nums[m]==target) return m;
            else if(nums[m]<target) i=m+1;
            else j=m-1;
        }
        return i;
    }
}
