// TC - O(n)
// SC - O(k)

// Java Code

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q=new ArrayDeque<>();
        int[] maxi=new int[nums.length-k+1];
        int j=0;
        for(int i=0; i<nums.length; i++){
            while(!q.isEmpty() && q.peekFirst()<i-k+1) q.pollFirst();
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i]) q.pollLast();
            q.addLast(i);
            if(i>=k-1){
                maxi[j++]=nums[q.peekFirst()];
            }
        }
        return maxi;
    }
}

// Python Code

class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """

        q = deque()

        res = []

        for i in range(len(nums)):

            while q and q[0] <= i - k:
                q.popleft()

            while q and nums[i] > nums[q[-1]]:
                q.pop()

            q.append(i)

            if i >= k - 1:
                res.append(nums[q[0]])

        return res
        
