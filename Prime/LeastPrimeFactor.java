import java.util.Arrays;

public class LeastPrimeFactor {
    public static void main(String[] args) {
        int n = 20;
        int[] lpf = leastPrimeFactors(n);
        System.out.println("Least Prime Factors up to " + n + ":");
        System.out.println(Arrays.toString(lpf));
    }
    public static int[] leastPrimeFactors(int n){
        int[] lpf=new int[n+1];
        lpf[0]=0;lpf[1]=1;
        if(n<=2) return lpf;
        for(int i=2; i<=n; i++){
            if(i%2==0)lpf[i]=2;
            else{
                lpf[i]=leastPrime(n);
            }
        }
        return lpf;
    }
    public static int leastPrime(int n){
        int limit=(int)Math.sqrt(n);
        for(int i=3; i<=limit; i+=2){
            if(n%i==0) return i;
        }
        return n;
    }
}
