class Solution {
    
    public int solve(int[][] grid,int i,int j,int xor,int[][][] dp){
        if(i<0 || j<0) return Integer.MAX_VALUE;
        
        xor^=grid[i][j];

        if(i==0 && j==0) return xor;

        if(dp[i][j][xor]!=-1) return dp[i][j][xor];

        int up=solve(grid,i-1,j,xor,dp);
        int left=solve(grid,i,j-1,xor,dp);

        return dp[i][j][xor]=Math.min(up,left);
    }
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][][] dp=new int[m+1][n+1][1024];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(grid,m-1,n-1,0,dp);
    }
}
