import java.util.HashSet;
import java.util.Set;

public class MaximumNumberofWordsYouCanType {
    public static void main(String[] args) {
        String text = "hello world";
        String brokenLetters = "ad";
        int result = canBeTypedWords(text, brokenLetters);
        System.out.println("Maximum Number of Words You Can Type :"+result);
    }
    public static int canBeTypedWords(String text, String b) {
        String[] str=text.split(" ");
        int c=0;
        Set<Character> s=new HashSet<>();
        for(char i:b.toCharArray()){
            s.add(i);
        }
        for(String i:str){
            for(char ch:i.toCharArray()){
                if(s.contains(ch)){
                    c++;
                    break;
                }
            }
        }
        return str.length-c;
    }
}
