
import java.util.Scanner;

public class VasyaandString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        String s=sc.next();
        char[] nums=s.toCharArray();
        int max1=0;
        int countb=0;
        int i=0,j=0;
        while(j<n){
            if(nums[j]=='b') countb++;
            while(countb>k){
                if(nums[i]=='b'){
                    countb--;
                }
                i++;
            }
            max1=Math.max(max1,j-i+1);
            j++;
        }
        int max2=0;
        int counta=0;
        i=0;j=0;
        while(j<n){
            if(nums[j]=='a') counta++;
            while(counta>k){
                if(nums[i]=='a'){
                    counta--;
                }
                i++;
            }
            max2=Math.max(max2,j-i+1);
            j++;
        }
        System.out.print(Math.max(max1,max2));
    }
}
