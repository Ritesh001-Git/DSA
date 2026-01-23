import java.util.Scanner;
public class Books {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int t=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0; i<n; i++){
            nums[i]=sc.nextInt();
        }
        int max=0,sum=0,j=0;
        for(int i=0; i<n; i++){
            sum+=nums[i];
            while(sum>t){
                sum-=nums[j++];
            }
            max=Math.max(max,i-j+1);
        }
        System.out.println(max);
    }
}