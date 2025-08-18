import java.util.*;
public class SlidingWindowMedian {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 8, 7};
        int k = 3;
        double[] ans=findMedian(arr,k);
        System.out.println(Arrays.toString(ans));
    }
    public static double[] findMedian(int[] arr, int k) {
        List<Integer> list=new ArrayList<>();
        double[] ans = new double[arr.length-k+1];
        int j=0;
        for(int i=0; i<arr.length; i++){
            int pos=Collections.binarySearch(list,arr[i]);
            if(pos<0) pos=-(pos+1);
            list.add(pos,arr[i]);
            if (list.size() > k) {
                int del=Collections.binarySearch(list, arr[i - k]);
                list.remove(del);
            }
            if(list.size()==k){
                if(k%2==1){
                    ans[j++]=list.get(k/2);
                }else{
                    long sum=(long)list.get(k/2 - 1)+(long)list.get(k/2);
                    ans[j++]=sum/2.0;
                }
            }
        }
        return ans;
    }
}
