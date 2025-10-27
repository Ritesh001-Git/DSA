import java.util.Arrays;

public class TwinPrime {
    public static void main(String[] args) {
        int n = 99;
        System.out.println("Twin Primes less than " + n + ":");
        printTwinPrimes(n);
    }
    public static void printTwinPrimes(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        for(int i=2; i*i<=n; i++){
            if(isPrime[i]){
                for(int j=i*2; j<=n; j+=i){
                    isPrime[j]=false;
                }
            }
        }
        for(int i=2; i<=n-2; i++){
            if(isPrime[i] && isPrime[i+2]){
                System.out.println("("+i+","+(i+2)+")");
            }
        }
    }
}
