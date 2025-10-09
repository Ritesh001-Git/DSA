import java.util.HashSet;

public class ContainDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(hasDuplicate(nums));
    }
    public static boolean hasDuplicate(int[] nums) {
        HashSet<Integer> a=new HashSet<>();
        for(int i:nums){
            if(a.contains(i)) return true;
            a.add(i);
        }
        return false;
    }
}
