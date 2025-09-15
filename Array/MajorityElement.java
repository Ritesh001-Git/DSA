import java.util.HashMap;
import java.util.Map;

class MajorityElement{
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i:nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        for(var i:mp.entrySet()){
            if(i.getValue()>nums.length/2) return i.getKey();
        }
        return -1;
    }
    

}