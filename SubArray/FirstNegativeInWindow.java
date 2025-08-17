// Removed unused import
import java.util.*;

public class FirstNegativeInWindow{
    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        System.out.println(firstNegInt(arr, k));
    }

    public static List<Integer> firstNegInt(int[] arr, int k) {
        Queue<Integer> q=new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<k-1; i++){
            if(arr[i]<0) q.offer(arr[i]);
        }
        for(int i=k-1; i<arr.length; i++){
            if(arr[i]<0) q.offer(arr[i]);
            if(!q.isEmpty()){
                ans.add(q.peek());
            }else{
                ans.add(0);
            }
            if(!q.isEmpty() && q.peek()==arr[i-k+1]){
                q.poll();
            }
        }
        return ans;
    }
}
