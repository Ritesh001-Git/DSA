// TC = O(n)
// SC = O(k)

// Java Code
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        int sum=0;
        int count=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            if(mp.containsKey(sum-k)){
                count+=mp.get(sum-k);
            }
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return count;
    }
}

// Python Code

class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        mp = {}
        mp[0] = 1

        s,c = 0, 0

        for i in range(len(nums)):
            s += nums[i]

            if s-k in mp:
                c += mp[s-k]

            mp[s] = mp.get(s, 0) + 1

        return c

        
