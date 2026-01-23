
import java.util.Scanner;

public class AliceBobandChocolate {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0; i<n; i++){
            nums[i]=sc.nextInt();
        }
        int bob=0,alice=0;
        int btime=0,atime=0;
        int i=0,j=n-1;
        while(i<=j){
            if(atime<=btime){
                atime+=nums[i++];
                alice++;
            }else{
                btime+=nums[j--];
                bob++;
            }
        }
        System.out.println(alice+" "+bob);
    }
}
