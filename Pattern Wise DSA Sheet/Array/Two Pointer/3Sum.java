// TC - O(n^2)
// SC - O(n²)

// Java Code

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
      
        List<List<Integer>> arr=new ArrayList<>();
      
        for(int i=0; i<nums.length-2; i++){
          
            if(i>0 && nums[i]==nums[i-1]) continue;
          
            int j=i+1;
            int k=nums.length-1;
          
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
              
                if(sum>0){
                    k--;
                }
                else if(sum<0){
                    j++;
                }
                else{
                    arr.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j<k && nums[j]==nums[j+1]) j++;
                    while(j<k && nums[k]==nums[k-1]) k--;
                    j++;
                    k--;
                }
            }
        }
      
        return arr;
      
    }
}

// Python Code

class Solution(object):
    def threeSum(self, arr):
        
        arr.sort()
        
        res = []
        for i in range(len(arr) - 2):
            if i > 0 and arr[i] == arr[i-1]: continue
            
            j, k = i + 1, len(arr) - 1
            
            while(j < k):
                s = arr[i] + arr[j] + arr[k]
                
                if s == 0:
                    res.append([arr[i], arr[j], arr[k]])

                    while j < k and arr[k] == arr[k-1]: k -= 1
                    while j < k and arr[j] == arr[j+1]: j += 1
                    j += 1
                    k -= 1
                
                elif s > 0:
                    k -= 1
                    
                else:
                    j += 1
                
        return res
        
