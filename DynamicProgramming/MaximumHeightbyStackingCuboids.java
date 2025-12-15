import java.util.*;
public class MaximumHeightbyStackingCuboids  {
    public static void main(String[] args) {
        int[][] cuboids = {{50,45,20},{95,37,53},{45,23,12}};
        System.out.println(maxHeight(cuboids));
    }
    public static int maxHeight(int[][] cuboids){
        for(int[] i:cuboids){
            Arrays.sort(i);
        }
        Arrays.sort(cuboids,(a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            else if(a[1]!=b[1]) return a[1]-b[1];
            else return a[2]-b[2];
        });
        int[] dp=new int[cuboids.length+1];
        Arrays.fill(dp,-1);
        int ans=0;
        for(int i=0; i<cuboids.length; i++){
            ans=Math.max(ans,solve(i,cuboids,dp));
        }
        return ans;
    }
    public static int solve(int idx,int[][] cuboids,int[] dp){
        int ans=cuboids[idx][2];
        if(dp[idx]!=-1) return dp[idx];
        for(int j=0; j<idx; j++){
            if(cuboids[j][0]<=cuboids[idx][0] && cuboids[j][1]<=cuboids[idx][1] && cuboids[j][2]<=cuboids[idx][2]){
                ans=Math.max(ans,cuboids[idx][2]+solve(j,cuboids,dp));
            }
        }
        return dp[idx]=ans;
    }
}
