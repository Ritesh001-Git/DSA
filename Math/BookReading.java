import java.util.Scanner;

public class BookReading {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        long[] nums=new long[t];
        int idx=0;
        while(t-->0){
            long n=sc.nextLong();
            long m=sc.nextLong();
            long sum=0;
            for(int i=1; i<=10; i++){
                sum+=(i*m)%10;
            }
            long c=n/m;
            long cycle=c/10;
            long rem=c%10;
            long ans=sum*cycle;
            for(int i=1; i<=rem; i++){
                ans+=(i*m)%10;
            }
            nums[idx++]=ans;
        }
        for(long i:nums){
            System.out.println(i);
        }
    }
}
