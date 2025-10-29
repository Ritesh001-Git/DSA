import java.util.Arrays;

public class PermutationinString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean result = checkInclusion(s1, s2);
        System.out.println("Does s2 contain a permutation of s1? " + result);
    }
    public static boolean checkInclusion(String s1, String s2) {
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
}
