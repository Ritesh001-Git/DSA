// TC - O(n)
// SC - O(1)

// Java Code

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        while(i<j){
            if(numbers[i]+numbers[j]==target) return new int[]{i+1,j+1};
            else if(numbers[i]+numbers[j]<target) i++;
            else j--;
        }
        return new int[]{-1,-1};
    }
}

// Python Code

class Solution:
    def twoSum(self, numbers: list[int], target: int) -> list[int]:
        i, j = 0, len(numbers) - 1
        while i < j:
            if numbers[i] + numbers[j] == target:
                return [i + 1, j + 1]
            elif numbers[i] + numbers[j] < target:
                i += 1
            else:
                j -= 1
        return [-1, -1]
