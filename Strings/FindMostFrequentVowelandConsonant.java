import java.util.HashMap;
import java.util.Map;

public class FindMostFrequentVowelandConsonant {
    public static void main(String[] args) {
        String s = "Hello World!";
        int result = maxFreqSum(s);
        System.out.println("Sum of most frequent vowel and consonant: " + result); // Output: 3 (e=1, l=3)
    }
    public static int maxFreqSum(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for (char i : s.toCharArray()) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        int v = 0;
        int c = 0;
        for (var i : mp.entrySet()) {
            var key = i.getKey();
            var value = i.getValue();
            if ("aeiou".contains(key.toString())) {
                v = Math.max(v, value);
            } else {
                c = Math.max(c, value);
            }
        }
        return v + c;
    }
}