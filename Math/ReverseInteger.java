public class ReverseInteger {
    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverse(x));
    }
    public static int reverse(int x) {
        long n=0;
        while(x!=0){
            n=n*10+x%10;
            if(n>Integer.MAX_VALUE || n<Integer.MIN_VALUE) return 0;
            x/=10;
        }
        return (int)n;
    }
}
