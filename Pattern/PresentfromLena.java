import java.util.Scanner;

public class PresentfromLena {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0; i<=n; i++){
            for (int s=0; s<n-i; s++) {
                System.out.print(" ");
            }
            for(int j=0; j<=i; j++){
                if (j>0) System.out.print(" ");
                System.out.print(j);
            }
            for(int j=i-1; j>=0; j--){
                System.out.print(j);            }
            System.out.println();
        }
        for(int i=n-1; i>=0; i--){
            for (int s=0; s<n-i; s++) {
                System.out.print(" ");
            }
            for(int j=0; j<=i; j++){
                if (j > 0) System.out.print(" ");
                System.out.print(j);
            }
            for(int j=i-1; j>=0; j--){
                System.out.print(" ");
                System.out.print(j);
            }
            System.out.println();
        }

    }
}
 