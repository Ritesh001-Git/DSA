import java.util.*;

public class BoxStacking{
    public static void main(String[] args) {
        int[] height = {4, 1, 4, 10};
        int[] width = {6, 2, 5, 12};
        int[] length = {7, 3, 6, 32};
        System.out.println(maxHeight(height,width,length));
    }

    // Dynamic Programming Memoization(Top-Down)
    public static int maxHeight(int[] height,int[] width,int[] length){
        List<int[]> box=new ArrayList<>();
        for(int i=0; i<height.length; i++){
            box.add(new int[]{height[i],width[i],length[i]});
            box.add(new int[]{height[i],length[i],width[i]});
            box.add(new int[]{length[i],width[i],height[i]});
            box.add(new int[]{length[i],height[i],width[i]});
            box.add(new int[]{width[i],height[i],length[i]});
            box.add(new int[]{width[i],length[i],height[i]});
        }
        Collections.sort(box,(a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            else return a[1]-b[1];
        });
        int[] dp=new int[box.size()];
        Arrays.fill(dp,-1);
        int ans=0;
        for(int i=0; i<box.size(); i++){
            ans=Math.max(ans,solve(i,box,dp));
        }
        return ans;
    }
    public static int solve(int idx,List<int[]> box,int[] dp){
        int ans=box.get(idx)[2];
        if(dp[idx]!=-1) return dp[idx];
        for(int j=0; j<idx; j++){
            if(box.get(j)[0]<box.get(idx)[0] && box.get(j)[1]<box.get(idx)[1]){
                ans=Math.max(ans,box.get(idx)[2]+solve(j,box,dp));
            }
        }
        return dp[idx]=ans;
    }
}