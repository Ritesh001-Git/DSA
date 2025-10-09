public class TwoSumIISortedArray {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(numbers, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
    public static int[] twoSum(int[] num, int target) {
        int i=0,j=num.length-1;
        while(i<j){
            if(num[i]+num[j]==target) return new int[]{i+1,j+1};
            else if(num[i]+num[j]>target) j--;
            else i++;
        }
        return new int[]{-1,-1};
    }
}
