import java.util.Scanner;

public class MaximumIncrease {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0; i<n; i++){
            nums[i]=sc.nextInt();
        }
        int len=1;
        int c=1;
        for(int i=1; i<n; i++){
            if(nums[i-1]<nums[i]){
                c++;
                len=Math.max(len,c);
            }else{
                c=1;
            }
        }
        System.out.println(len);
    }
}
