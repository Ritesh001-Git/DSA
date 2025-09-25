public class CountElementsWithMaximumFrequency {
    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,1};
        System.out.println(maxFrequencyElements(nums)); // Output: 5
    }
    public static int maxFrequencyElements(int[] nums) {
        int[] freq=new int[101];
        int max=0;
        for(int i:nums){
            freq[i]++;
            max=Math.max(max,freq[i]);
        }
        int sum=0;
        for(int i:freq){
            if(i==max) sum+=max;
        }
        return sum;
    }
}
