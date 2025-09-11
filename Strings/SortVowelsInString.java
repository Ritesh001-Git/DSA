import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortVowelsInString {
    public static void main(String[] args) {
        String s = "leetcodeisacommunityforcoders";
        System.out.println(sortVowels(s));
    }
    public static String sortVowels(String s) {
        List<Character> l=new ArrayList<>();
        char[] arr=s.toCharArray();
        for(char ch:arr){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
            || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                l.add(ch);
            }
        }
        Collections.sort(l);
        int c=0;
        for(int i=0; i<s.length(); i++){
            char ch=arr[i];
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
            || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                arr[i]=l.get(c++);
            }
        }
        return new String(arr);

    }
}
