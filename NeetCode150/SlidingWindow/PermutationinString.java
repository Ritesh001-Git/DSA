import java.util.Arrays;

public class PermutationinString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean result = checkInclusion1(s1, s2);
        System.out.println("Does s2 contain a permutation of s1? " + result);
        result = checkInclusion2(s1, s2);
        System.out.println("Does s2 contain a permutation of s1? " + result);
    }

    // Brute Force Approach
    public static boolean checkInclusion1(String s1, String s2) {
        for(int i=0; i<=s2.length()-s1.length(); i++){
            String s=s2.substring(i,i+s1.length());
            char[] arr1=s.toCharArray();
            char[] arr2=s1.toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            if(Arrays.equals(arr1,arr2)) return true;
        }
        return false;
    }

    // Sliding Window Approach
    public static boolean checkInclusion2(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        if(m>n) return false;
        int[] freq=new int[26];
        int[] window=new int[26];

        for(int i=0; i<m; i++) freq[s1.charAt(i)-'a']++;
        for(int i=0; i<m; i++) window[s2.charAt(i)-'a']++;
        if(Arrays.equals(freq,window)) return true;

        for(int i=m; i<n; i++){
            window[s2.charAt(i)-'a']++;
            window[s2.charAt(i-m)-'a']--;
            if(Arrays.equals(freq,window)) return true;
        }
        return false;
    }
}
