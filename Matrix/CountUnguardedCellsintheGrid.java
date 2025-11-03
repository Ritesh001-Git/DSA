public class CountUnguardedCellsintheGrid {
    public static void main(String[] args) {
        int m = 4, n = 6;
        int[][] guards = { { 0, 0 }, { 1, 1 }, { 2, 3 } };
        int[][] walls = { { 0, 1 }, { 2, 2 }, { 1, 4 } };
        System.out.println(countUnguarded(m, n, guards, walls)); // Output: 7
    }
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid=new int[m][n];
        boolean[][] seen=new boolean[m][n];
        for(int[] g:guards) grid[g[0]][g[1]]=1;
        for(int[] w:walls) grid[w[0]][w[1]]=2;

        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};

        for(int[] g:guards){
            int gi=g[0];
            int gj=g[1];

            for(int[] d:dirs){
                int x=gi+d[0];
                int y=gj+d[1];

                while(x>=0 && x<m && y>=0 && y<n && grid[x][y]!=1 && grid[x][y]!=2){
                    seen[x][y]=true;
                    x+=d[0];
                    y+=d[1];
                }
            }
        }
        int c=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0 && !seen[i][j]){
                    c++;
                }
            }
        }
        return c;
        
    }
}
