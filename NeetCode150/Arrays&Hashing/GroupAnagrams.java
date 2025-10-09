import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
        System.out.println(groupAnagrams2(strs));
    }
    //Method 1: HashTable
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp=new HashMap<>();
        for(String i:strs){
            int[] freq=new int[26];
            for(char j:i.toCharArray()){
                freq[j-'a']++;
            }
            String s=Arrays.toString(freq);
            mp.putIfAbsent(s,new ArrayList<>());
            mp.get(s).add(i);
        }
        return new ArrayList<>(mp.values());
    }

    //Method 2: Sorting each string and using it as a key
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String,List<String>> mp=new HashMap<>();
        for(String i:strs){
            int[] freq=new int[26];
            for(char j:i.toCharArray()){
                freq[j-'a']++;
            }
            String s=Arrays.toString(freq);
            mp.putIfAbsent(s,new ArrayList<>());
            mp.get(s).add(i);
        }
        return new ArrayList<>(mp.values());
    }
}
