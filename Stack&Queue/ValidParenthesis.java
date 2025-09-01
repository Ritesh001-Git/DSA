import java.util.*;
public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "{[()]}";
        boolean result = isValid(s);
        System.out.println("Is the parentheses valid? " + result); // Output: true
    }
    public static boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        if(s.length()<=1) return false;
        for(char i:s.toCharArray()){
            if(i=='(' || i=='[' || i=='{'){
                st.push(i);
            }else{
                if(st.empty() || 
                (i==')' && st.peek()!='(') || 
                (i==']' && st.peek()!='[') || 
                (i=='}' && st.peek()!='{')){
                    return false;
                }else{
                    st.pop();
                }
            }
        }
        return st.empty();
    }
}
