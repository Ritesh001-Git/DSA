import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '6', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("Is the Sudoku board valid? " + isValidSudoku(board)); // Output: true
    }
    public static boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            Set<Character> s=new HashSet<>();
            for(int j=0; j<9; j++){
                if(board[i][j]=='.') continue;
                if(s.contains(board[i][j])) return false;
                s.add(board[i][j]);
            }
        }
        for(int i=0; i<9; i++){
            Set<Character> s=new HashSet<>();
            for(int j=0; j<9; j++){
                if(board[j][i]=='.') continue;
                if(s.contains(board[j][i])) return false;
                s.add(board[j][i]);
            }
        }
        for(int k=0; k<9; k++){
            Set<Character> s=new HashSet<>();
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    int r=(k/3)*3+i;
                    int c=(k%3)*3+j;
                    if(board[r][c]=='.') continue;
                    if(s.contains(board[r][c])) return false;
                    s.add(board[r][c]);
                }
            }
        }
        return true;
    }
}
