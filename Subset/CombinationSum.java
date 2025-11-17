import java.util.*;
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates={2,3,5};
        int target=8;
        System.out.println(combinationSum(candidates,target));
    }
    public static  List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        solve(res,candidates,curr,target,0);
        return res;
    }
    public static void solve(List<List<Integer>> res,int[] candidates,List<Integer> curr,int target,int idx){
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(idx==candidates.length || target<0) return;
        curr.add(candidates[idx]);
        solve(res, candidates, curr, target-candidates[idx], idx);
        curr.remove(curr.size()-1);
        solve(res, candidates, curr, target, idx+1);
    }
}
