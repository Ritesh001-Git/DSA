import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println("Length of longest substring without repeating characters: " + result); // Output: 3
    }
    // Sliding Window Approach
    public static  int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int max=0;
        int j=0,i=0;
        while(i<s.length()){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i++));
                max=Math.max(max,set.size());
            }else{
                set.remove(s.charAt(j++));
            }
        }
        return max;
    }
}
