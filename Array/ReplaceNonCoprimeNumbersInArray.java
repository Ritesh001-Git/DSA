import java.util.ArrayList;
import java.util.List;

public class ReplaceNonCoprimeNumbersInArray {
    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 2, 7, 9};
        List<Integer> result = replaceNonCoprimes(arr);
        System.out.println("Resulting array: " + result);
    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public static int lcm(int a,int b) {
        if (a==0 || b==0) return 0;
        return (int)((long)a*b/gcd(a,b));
    }
    public static List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> l=new ArrayList<>();
        l.add(nums[0]);
        if(nums.length == 1){
            return l;
        }
        for(int i=1; i<nums.length; i++){
            l.add(nums[i]);
            while(l.size()>1){
                int a=l.get(l.size()-1);
                int b=l.get(l.size()-2);
                int g=gcd(a,b);

                if (g==1) break;
                l.remove(l.size()-1);
                l.set(l.size()-1,lcm(a, b));
            }
        }
        return l;
    }
}
