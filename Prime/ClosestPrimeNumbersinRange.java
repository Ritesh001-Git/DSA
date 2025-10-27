import java.util.*;
public class ClosestPrimeNumbersinRange {
    public static void main(String[] args) {
        int left = 50000000, right = 100000000;
        int[] result = closestPrimes(left, right);
        System.out.println("Closest primes between " + left + " and " + right + ": [" + result[0] + ", " + result[1] + "]");
    }
    public static int[]closestPrimes(int l,int r){
        int n=(int)Math.sqrt(r);
        boolean[] isPrime=new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;isPrime[1]=false;
        for(int i=0; i*i<=n; i++){
            if(isPrime[i]){
                for(int j=i*i; j<=n; j+=i){
                    isPrime[j]=false;
                }
            }
        }
        List<Integer> primes=new ArrayList<>();
        for(int i=0; i<=n; i++){
            if(isPrime[i]) primes.add(i);
        }
        int sz=r-l+1;
        boolean[] isPrimeRange=new boolean[sz];
        Arrays.fill(isPrimeRange,true);
        if(l==1) isPrimeRange[0] = false;
        for(int i:primes){
            for(int j=i+i; j<=r; j+=i){
                if(j>=l && j<=r) isPrimeRange[j-l]=false;
            }
        }
        List<Integer> primeNumbersInRange=new ArrayList<>();
        for(int i=0; i<sz; i++){
            if(isPrimeRange[i]) primeNumbersInRange.add(i+l);
        }
        int minDiff=Integer.MAX_VALUE;
        int[] ans=new int[]{-1,-1};
        for(int i=1; i<primeNumbersInRange.size(); i++){
            System.out.println(primeNumbersInRange.get(i));
            int diff=primeNumbersInRange.get(i)-primeNumbersInRange.get(i-1);
            if(diff<minDiff){
                minDiff=diff;
                ans[0]=primeNumbersInRange.get(i-1);
                ans[1]=primeNumbersInRange.get(i);
            }
        }
        return ans;
    }
}
