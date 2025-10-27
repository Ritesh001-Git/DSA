import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimePairsWithTargetSum {
    public static void main(String[] args) {
        int n = 938;
        List<List<Integer>> result = findPrimePairs(n);
        System.out.println("Prime pairs with sum " + n + ": " + result);
    }
    public static List<List<Integer>> findPrimePairs(int n) {
        boolean[] isPrime=new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;
        for(int i=2; i*i<=n; i++){
            if(isPrime[i]){
                for(int j=i*i; j<=n; j+=i){
                    isPrime[j]=false;
                }
            }
        }
        List<Integer> prime=new ArrayList<>();
        for(int i=2; i<=n; i++){
            if(isPrime[i]) prime.add(i);
        }
        List<List<Integer>> res=new ArrayList<>();
        int i=0,j=prime.size()-1;
        while(i<=j){
            if(prime.get(i)+prime.get(j)==n){
                res.add(new ArrayList<>(List.of(prime.get(i),prime.get(j))));
                i++;
                j--;
            }
            else if(prime.get(i)+prime.get(j)<n) i++;
            else j--;
        }
        return res;
    }
}
