public class ValidAnagram {
    public static void main(String[] args) {
        String s="racecar";
        String t="carerac";
        System.out.println(validAnagram(s,t));
    }
    static boolean validAnagram(String s,String t) {
        if(s.length()!=t.length()) return false;
        int[] freq=new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
        for(int i:freq){
            if(i!=0) return false;
        }
        return true;
    }
}
