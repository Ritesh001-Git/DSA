// TC - O(n)
// SC - O(1)

// Java Code
class Solution {
    public int totalFruit(int[] fruits) {
        int i=0,j=0;
        int len=0;
      
        Map<Integer,Integer> mp=new HashMap<>();
      
        while(j<fruits.length){
            mp.put(fruits[j],mp.getOrDefault(fruits[j],0)+1);
          
            while(mp.size()>2){
                mp.put(fruits[i],mp.getOrDefault(fruits[i],0)-1);
                if(mp.get(fruits[i])==0) mp.remove(fruits[i]);
                i++;
            }
          
            len=Math.max(len,j-i+1);
            j++;
        }
      
        return len;
    }
}

// Python Code
class Solution(object):
    def totalFruit(self, fruits):
        """
        :type fruits: List[int]
        :rtype: int
        """

        mp = {}
        j = 0
        maxLen = 0

        for i in range(len(fruits)):
            mp[fruits[i]] = mp.get(fruits[i], 0) + 1

            while len(mp) > 2:
                mp[fruits[j]] -= 1
                if mp[fruits[j]] == 0:
                    del mp[fruits[j]]
                j += 1

            maxLen = max(maxLen, i - j + 1)

        return maxLen
