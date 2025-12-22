public class WordSearchInAStraightLine {
    public static void main(String[] args) {

        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

        String word = "AFEE";

        boolean result = exist(board, word);

        System.out.println("Word found? " + result);
    }
    public static boolean exist(char[][] board, String word) {
        int[] dx={1,0,-1,0,1,1,-1,-1};
        int[] dy={0,1,0,-1,1,-1,1,-1}; 
        int n=board.length;int m=board[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==word.charAt(0)){
                    for(int k=0; k<8; k++){
                        if(solve(board,word,i,j,dx[k],dy[k],0)) return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean solve(char[][] board, String word,int i,int j,int dx,int dy,int idx){
        int n=board.length;int m=board[0].length;
        if(idx==word.length()) return true;
        if(i<0 || j<0 || i>=n || j>=m || board[i][j]!=word.charAt(idx)) return false;
        return solve(board, word,i+dx,j+dy,dx,dy,idx+1);
    }
}
