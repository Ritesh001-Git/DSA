

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height)); // Output: 6
        System.out.println(trap2(height)); // Output: 6
    }
    // Prefix and Suffix Max Approach
    public static int trap(int[] height) {
        int n=height.length;
        if(n==0) return 0;
        int[] left=new int[n];
        left[0]=height[0];
        for(int i=1; i<n; i++){
            left[i]=Math.max(left[i-1],height[i]);
        }
        int right=height[n-1];
        int water=0;
        for(int i=n-1; i>=0; i--){
            right=Math.max(right,height[i]);
            water+=Math.min(right,left[i])-height[i];
        }
        return water;
    }
    // Two Pointer Approach
    public static int trap2(int[] height){
        int l=0,r=height.length-1;
        int leftMax=0,rightMax=0;
        int water=0;
        while(l<r){
            if(leftMax<rightMax){
                l++;
                leftMax=Math.max(leftMax,height[l]);
                water+=leftMax-height[l];
            }else{
                r--;
                rightMax=Math.max(rightMax,height[r]);
                water+=rightMax-height[r];
            }
        }
        return water;
    }
}
