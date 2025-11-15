
import java.util.*;

public class DifferentWaystoAddParentheses {
    public static void main(String[] args) {
        String exp="2*3-4*5";
        List<Integer> l=diffWaysToCompute(exp);
        System.err.println(l);
    }
    public static List<Integer> diffWaysToCompute(String exp){
        List<Integer> res=new ArrayList<>();
        for(int i=0; i<exp.length(); i++){
            if(exp.charAt(i)=='+' || exp.charAt(i)=='-' || exp.charAt(i)=='*'){
                List<Integer> left=diffWaysToCompute(exp.substring(0,i));
                List<Integer> right=diffWaysToCompute(exp.substring(i+1));
                for(int x:left){
                    for(int y:right){
                        if(exp.charAt(i)=='+') res.add(x+y);
                        if(exp.charAt(i)=='-') res.add(x-y);
                        if(exp.charAt(i)=='*') res.add(x*y);
                    }
                }

            }
        }
        if(res.isEmpty()){
            res.add(Integer.valueOf(exp));
        }
        return res;
    }
}
