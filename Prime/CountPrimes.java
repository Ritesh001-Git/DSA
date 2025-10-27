import java.util.Arrays;

public class CountPrimes {
    public static void main(String[] args) {
        int n = 100;
        int count = countPrimes(n);
        System.out.println("Number of primes less than " + n + ": " + count);
    }
    public static int countPrimes(int n) {
        int c=0;
        if(n<=2) return 0;
        boolean[] arr=new boolean[n];
        Arrays.fill(arr,true);
        arr[0]=false;arr[1]=false;
        for(int i=2; i*i<n; i++){
            if(arr[i]==true){
                for(int j=i+i; j<n; j+=i) arr[j]=false;
            }
        }
        for(int i=0; i<n; i++) if(arr[i]) c++;
        return c;
    }
}
