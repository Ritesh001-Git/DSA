import java.util.*;
public class GenerateAllBinaryStrings {
    public static void main(String[] args) {
        int n=3;
        ArrayList<String> res=binstr(n);
        System.out.println(res);
    }
    public static ArrayList<String> binstr(int n){
        StringBuilder s=new StringBuilder();
        for(int i=0; i<n; i++)s.append("0");
        ArrayList<String> res=new ArrayList<>();
        solve(0,s,res);
        return res;
    }
    public static ArrayList<String> solve(int idx,StringBuilder s,ArrayList<String> res){
        if(idx==s.length()){
            res.add(s.toString());
            return res;
        }

        s.setCharAt(idx,'0');
        solve(idx+1,s,res);
        s.setCharAt(idx,'1');
        solve(idx+1,s,res);

        return res;
    }
}
