import java.util.*;
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Length of longest consecutive sequence: " + longestConsecutive(nums)); // Output: 4
    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> s=new HashSet<>();
        for(int n: nums) s.add(n);
        int c=0;
        for(int i:s){
            if(!s.contains(i-1)){
                int l=1;
                while(s.contains(i+l)) l++;
                c=Math.max(c,l);
            }
        }
        return c;

    }
}
