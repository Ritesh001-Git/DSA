public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        String result = longestPalindrome(s);
        String result2 = longestPalindrome2(s);
        System.out.println("Longest palindromic substring: " + result); // Output: "bab" or "aba"
        System.out.println("Longest palindromic substring: " + result2); // Output: "bab" or "aba"

    }
    // Brute Force Approach
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

    // Expand Around Center
    public static String longestPalindrome2(String s) {
        if(s==null || s.length()<2) return s;
        int st=0,end=0;
        for(int i=0; i<s.length(); i++){
            int even=centre(s,i,i);
            int odd=centre(s,i,i+1);
            int len=Math.max(even,odd);
            if(len>end-st){
                st=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(st,end+1);
    }
    private static  int centre(String s, int st, int end) {
        while(st>=0 && end<s.length() && s.charAt(st)==s.charAt(end)) {
            st--;
            end++;
        }
        return end-st-1;
    }
}
