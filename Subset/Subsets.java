import java.util.*;
public class Subsets{
    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> subset= subsets(nums);
        System.err.println(subset);
    }
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> s=new ArrayList<>();
        solve(res,s,0,nums);
        return res;
    }
    public static void solve(List<List<Integer>> res,List<Integer> s,int idx,int[] nums){
        if(idx==nums.length){res.add(new ArrayList<>(s));return;}
        s.add(nums[idx]);
        solve(res, s, idx+1, nums);
        s.remove(s.size()-1);
        solve(res, s, idx+1, nums);
    }
}