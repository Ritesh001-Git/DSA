import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        FourSum fourSumInstance = new FourSum();
        System.out.println(fourSumInstance.fourSum(nums, target));
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        int l=nums.length;
        Arrays.sort(nums);
        for(int i=0; i<l-3; i++){
            if(i>0 && nums[i-1]==nums[i]) continue;
            for(int j=i+1; j<l-2; j++){
                if(j>i+1 && nums[j-1]==nums[j]) continue;
                int k=j+1;
                int p=l-1;
                while(k<p){
                    long sum=nums[i]+nums[j];
                    sum+=nums[k]+nums[p];
                    if(sum==target){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[k],nums[p]));
                        k++;
                        p--;
                        while(k<l && nums[k-1]==nums[k]) k++;
                        while(k<l && nums[p+1]==nums[p]) p--;
                    }else if(sum<target) k++;
                    else p--;
                }
            }
        }
        return ans;
    }
}
