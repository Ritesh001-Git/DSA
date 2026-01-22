import java.util.*;
public class AlmostPrime {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] cnt=new int[n+1];
        for(int i=2; i<=n; i++){
            if(cnt[i]==0){
                for(int j=i; j<=n; j+=i){
                    cnt[j]++;
                }
            }
        }
        int ans=0;
        for(int i=1; i<=n; i++){
            if(cnt[i]==2) ans++;
        }

        System.out.println(ans);
        sc.close();
    }
}
