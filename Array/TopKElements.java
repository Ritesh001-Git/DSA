
import java.util.*;

public class TopKElements {
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,1,2,3,1,3,2};
        int k = 2;
        int[] result = topKElements(arr, k);
        System.out.println(Arrays.toString(result));
    }
    public static int[] topKElements(int[] arr, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i:arr){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        List<Integer> l=new ArrayList<>(mp.values());
        Collections.sort(l,Collections.reverseOrder());
        int threshold=l.get(k-1);
        int[] res=new int[k];
        int index=0;
        for(int i:mp.keySet()){
            if(mp.get(i)>=threshold){
                res[index++]=i;
            }
        }
        return res;
    }
}
