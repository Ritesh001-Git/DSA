public class FindGreatestCommonDivisorofArray{
    public static void main(String[] args) {
        int[] arr={2,5,6,9,10};
        System.out.println(findGCD(arr));
    }
    public static int findGCD(int[] nums){
        int min=1001;
        int max=-1;
        for(int i:nums){
            min=Math.min(min,i);
            max=Math.max(max,i);
        }
        return gcd(max,min);
    }
    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}