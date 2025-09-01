public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        String result = longestPalindrome(s);
        System.out.println("Longest palindromic substring: " + result); // Output: "bab" or "aba"
    }
    private static  boolean ispalin(int i,int j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public static  String longestPalindrome(String s) {
        int n=s.length();
        if(n==0) return "";
        String res="";
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(ispalin(i,j,s) && j-i+1>res.length()){
                    res=s.substring(i,j+1);
                }
            }
        }
        return res;
    }
}
