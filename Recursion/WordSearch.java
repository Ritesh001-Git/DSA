public class WordSearch {
    public static void main(String[] args) {

        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

        String word = "ABCCED";

        boolean result = exist(board, word);

        System.out.println("Word found? " + result);
    }
    public static boolean exist(char[][] board, String word) {
        int n=board.length;int m=board[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==word.charAt(0)){
                    if(solve(board,word,i,j,0)) return true;
                }
            }
        }
        return false;
    }
    public static boolean solve(char[][] board, String word,int i,int j,int k){
        int n=board.length;int m=board[0].length;
        if(k==word.length()) return true;
        if(i<0 || j<0 || i>=n || j>=m || board[i][j]!=word.charAt(k)) return false;
        char temp=word.charAt(k);
        board[i][j]='*';
        boolean res=solve(board,word,i+1,j,k+1) ||
                solve(board,word,i-1,j,k+1) ||
                solve(board,word,i,j+1,k+1) ||
                solve(board,word,i,j-1,k+1);
        board[i][j]=temp;
        return res;

    }
}
