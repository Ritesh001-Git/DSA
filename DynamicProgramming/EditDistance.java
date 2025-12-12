public class EditDistance {
    public static void main(String[] args) {
        String word1 = "intention", word2 = "execution";
        System.out.println(minDistance(word1,word2));
    }

    // Recursion (TLE)
    public static int minDistance(String word1,String word2){
        return solve(0,0,word1,word2);
    }
    public static int solve(int i,int j,String word1,String word2){
        if(word1.length()==i) return word2.length()-j;
        if(word2.length()==j) return word1.length()-i;
        if(word1.charAt(i)==word2.charAt(j)) return solve(i+1,j+1,word1,word2);
        return 1+Math.min(solve(i+1,j+1,word1, word2),Math.min(solve(i+1,j,word1,word2),solve(i,j+1,word1,word2)));
    }
}
