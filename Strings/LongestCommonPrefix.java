import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs)); // Output: "fl"
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0) return "";
        Arrays.sort(strs);
        char[] a=strs[0].toCharArray();
        char[] b=strs[strs.length-1].toCharArray();
        StringBuilder s=new StringBuilder();
        for(int i=0; i < a.length && i < b.length; i++){
            if(a[i]==b[i]){
                s.append(a[i]);
            }else{
                return s.toString();
            }
        }
        return s.toString();

    }
}
