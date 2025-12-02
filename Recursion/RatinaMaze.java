import java.util.*;

public class RatinaMaze {
    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {0, 1, 1, 0},
            {1, 1, 1, 1}
        };
        ArrayList<String> path=ratInMaze(maze);
        System.out.println(path);
    }
    public static ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> path=new ArrayList<>();
        solve(maze.length,maze,path,0,0,"");
        Collections.sort(path);
        return path;
    }
    public static void solve(int n,int[][] maze,ArrayList<String> path,int i,int j,String s){
        if(i==n-1 || j==n-1) path.add(s);
        if(i<0 || j<0 || i>=n-1 || j>=n-1 || maze[i][j]==0) return;
        maze[i][j]=0;
        solve(n, maze, path, i-1, j, s+"U");
        solve(n, maze, path, i+1, j, s+"D");
        solve(n, maze, path, i, j-1, s+"L");
        solve(n, maze, path, i, j+1, s+"R");
        maze[i][j]=1;
    }
}
