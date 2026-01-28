import java.util.Scanner;

public class Worms {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0; i<n; i++){
            nums[i]=sc.nextInt();
        }
        int r=sc.nextInt();
        int[] ans=new int[r];
        for(int i=0; i<r; i++){
            ans[i]=sc.nextInt();
        }
        for(int i=1; i<n; i++){
            nums[i]+=nums[i-1];
        }
        int idx=0;
        int[] res=new int[r];
        while(idx<r){
            int i=0,j=n-1;
            int target=ans[idx];
            while(i<=j){
                int mid=i+(j-i)/2;
                if(target<=nums[mid]) j=mid-1;
                else i=mid+1;
            }
            res[idx]=i+1;
            idx++;
        }
        for(int x:res){
            System.out.print(x+" ");
        }
    }
}
