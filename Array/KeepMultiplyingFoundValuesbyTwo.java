public class KeepMultiplyingFoundValuesbyTwo {
    public static void main(String[] args) {
        int[] nums={5,3,6,1,12};
        int original = 3;
        System.out.println(findFinalValue(nums,original));
    }
    public static int findFinalValue(int[] nums,int original){
        boolean[] memo=new boolean[1001];
        for(int i:nums){
            memo[i]=true;
        }
        int i=original;
        while(i<=1000){
            if(memo[i]) i*=2;
            else break;
        }
        return i;
    }
}
