import java.util.*;
public class CountEqualEvenOddSumSubArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 1};
        // Subarray {3, 4, 1} starting at index 2:
        // Even indices: 3 + 1 = 4
        // Odd indices: 4 = 4
        System.out.println("Array 1: " + java.util.Arrays.toString(arr1));
        System.out.println("Count: " + countEqualEvenOddSumSubarrays(arr1)); // Expected: 1
        System.out.println("---");
        
        int[] arr2 = {1, 2, 1, 2, 1, 2};
        // Subarrays: {1, 2}, {2, 1}, {1, 2}, {2, 1}, {1, 2, 1, 2}, {2, 1, 2, 1}, {1, 2, 1, 2, 1, 2}
        System.out.println("Array 2: " + java.util.Arrays.toString(arr2));
        System.out.println("Count: " + countEqualEvenOddSumSubarrays(arr2)); // Expected: 7
        System.out.println("---");
        
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        System.out.println("Array 3: " + java.util.Arrays.toString(arr3));
        System.out.println("Count: " + countEqualEvenOddSumSubarrays(arr3)); 
    }
    public static int countEqualEvenOddSumSubarrays(int[] arr){
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int prefixSum=0;
        int c=0;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0; i<arr.length; i++){
            int currentElement=arr[i];
            if(i%2==0) prefixSum+=currentElement;
            else prefixSum-=currentElement;

            if(mp.containsKey(prefixSum)){
                c+=mp.get(prefixSum);
            }
            mp.put(prefixSum,mp.getOrDefault(i,0)+1);
        }
        return c;

    }
}
