public class CollectionOfPens {
    public static void main(String[] args) {
        int A=7;
        int B=12;
        int C = minThirdPiles(A, B);
        System.out.println("The minimum number of pens in the third pile is: " + C);
    }
    public static int minThirdPiles(int A, int B) {
        int sum=A+B;
        if(sum<=2) return 1;
        sum+=(sum%2==0)?1:2;
        while (true){
            if(isPrime(sum)) return sum-A-B;
            else sum+=2;
        }
    }
    public static boolean isPrime(int n){
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
