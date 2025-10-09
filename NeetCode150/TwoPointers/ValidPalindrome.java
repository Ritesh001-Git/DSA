
public class ValidPalindrome {
    public static void main(String[] args) {
        String s="Was it a car or a cat I saw?";
        System.out.println(isPalindrome(s)); // Output: true
    }
    public static String alphanumericAnyCase(String input) {
        if (input==null) return null;
        return input.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
    }
    public static boolean isPalindrome(String s) {
        String t=alphanumericAnyCase(s);
        int i=0,j=t.length()-1;
        while(i<j){
            if(t.charAt(i)!=t.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
