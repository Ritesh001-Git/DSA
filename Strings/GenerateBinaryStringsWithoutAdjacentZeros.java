import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStringsWithoutAdjacentZeros {
    public static void main(String[] args) {
        int n=3;
        List<String> res=validStrings(n);
        System.out.println(res);
    }
    public static List<String> validStrings(int n) {
        ArrayList<String> res=new ArrayList<>();
        StringBuilder s=new StringBuilder();
        for (int i=0; i<n; i++) s.append('0');
        solve(0,s,res,-1);
        return res;
    }
    public static List<String> solve(int idx,StringBuilder s,List<String> res,int prev){
        if(idx==s.length()){
            res.add(s.toString());
            return res;
        }
        if(prev!=0){
            prev=0;
            s.setCharAt(idx,'0');
            solve(idx+1,s,res,prev);
        }
        s.setCharAt(idx,'1');
        prev=1;
        solve(idx+1,s,res,prev);

        return res;
    }
}
