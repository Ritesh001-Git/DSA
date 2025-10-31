public class PrimePalindrome {
    public static void main(String[] args) {
        int N = 31;
        int result = primePalindrome(N);
        System.out.println("The smallest prime palindrome greater than or equal to " + N + " is: " + result);
    }
    public static int primePalindrome(int n) {
        if(n==1) return 2; 
        while (true) {
            if (isPal(n) && isPrime(n))
                return n;
            n++;
            if (10000000 < n && n < 100000000)
                n = 100000000;
        }
    }
    static boolean isPrime(int n) {
        for(int i = 2; i<=(int) Math.sqrt(n); i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
    static boolean isPal(int n) {
        int rev = 0;
        int temp = n;
        while(n != 0) {
            int r = n%10;
            rev = rev*10+r;
            n = n/10;
        }
        return rev == temp;
    }
}
