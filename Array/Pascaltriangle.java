import java.util.ArrayList;
import java.util.List;

public class Pascaltriangle {
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }
    public static List<List<Integer>> generate(int n) {
        List<List<Integer>> ans=new ArrayList<>();
        if(n<=0) return ans;
        ans.add(new ArrayList<>(List.of(1)));
        for(int i=1; i<n; i++){
            List<Integer> prev=ans.get(i-1);
            List<Integer> curr=new ArrayList<>(i+1);
            curr.add(1);
            for(int j=1; j<i; j++){
                int val=prev.get(j-1)+prev.get(j);
                curr.add(val);
            }
            curr.add(1);
            ans.add(curr);
        }
        return ans;
    }
}
