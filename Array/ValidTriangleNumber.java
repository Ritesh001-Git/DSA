import java.util.*;
public class ValidTriangleNumber {
    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 4, 7, 5, 4, 9, 3};
        System.out.println(triangleNumber(nums)); // Output: 3
    }
    public static int triangleNumber(int[] nums){
        Arrays.sort(nums);
        int n=nums.length;
        int c=0;
        for(int i=n-1; i>=2; i--){
            int l=0,r=i-1;
            while(l<r){
                if(nums[l]+nums[r]>nums[i]){
                    c+=(r-l);
                    r--;
                }else{
                    l++;
                }
            }
        }
        return c;
    }
}
