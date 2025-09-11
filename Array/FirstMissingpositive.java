import java.util.HashSet;
import java.util.Set;

public class FirstMissingpositive {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] nums) {
        Set<Integer> s=new HashSet<>();
        for(int i:nums){
            s.add(i);
        }
        for(int i=1; i<=nums.length+1; i++){
            if(!s.contains(i)) return i;
        }
        return -1;
    }
}
