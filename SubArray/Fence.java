import  java.util.*;
public class Fence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0; i<n; i++){
            nums[i]=sc.nextInt();
        }
        int curr=0;
        for(int i=0; i<k; i++){
            curr+=nums[i];
        }
        int min=curr;
        int index=1;
        for(int i=1; i<=n-k; i++){
            curr=curr+nums[i+k-1]-nums[i-1];
            if(min>curr){
                min=curr;
                index=i+1;
            }
        }
        System.out.println(index);

    }
}
