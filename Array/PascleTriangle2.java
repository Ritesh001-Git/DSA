import java.util.ArrayList;
import java.util.List;

public class PascleTriangle2 {
    public static void main(String[] args) {
        int numRows = 5;
        List<Integer> triangle = getRow(numRows);
        for (Integer value : triangle) {
            System.out.print(value+" ");
        }
        }
        public static List<Integer> getRow(int n) {
        List<List<Integer>> ans=new ArrayList<>();
        if(n<=0) return new ArrayList<>(List.of(1));
        ans.add(new ArrayList<>(List.of(1)));
        for(int i=1; i<n+1; i++){
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
        return ans.get(n);
    }
    }

