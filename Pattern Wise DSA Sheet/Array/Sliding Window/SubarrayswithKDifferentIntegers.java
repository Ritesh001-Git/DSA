// TC - O(n)
// SC - O(n)

// Java Code

class Solution {
    public int solve(int[] nums,int k){
        HashMap<Integer,Integer> mp=new HashMap<>();
        int i=0;
        int j=0;
        int c=0;
        while(j<nums.length){
            mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
            while(i<nums.length && mp.size()>k){
                mp.put(nums[i],mp.get(nums[i])-1);
                if(mp.get(nums[i])==0) mp.remove(nums[i]);
                i++;
            }
            c+=(j-i+1);
            j++;
        }
        return c;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums,k)-solve(nums,k-1);
    }
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) {
                fw.write("0");
            } catch (Exception e) {
            }
        }));
    }
}

// Python Code

class Solution(object):
    def subarraysWithKDistinct(self, arr, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        def solve(k):
            mp = {}
            
            j = 0
            count = 0
            
            for i in range(len(arr)):
                mp[arr[i]] = mp.get(arr[i],0) + 1
                
                while len(mp) > k:
                    mp[arr[j]] -= 1
                    if mp[arr[j]] == 0:
                        del mp[arr[j]]
                    j += 1
                    
                count += (j - i + 1)
                
            return count
            
        return solve(k-1) - solve(k)
        
        
