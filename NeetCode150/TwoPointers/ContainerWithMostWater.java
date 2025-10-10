public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height)); // Output: 49
    }
    public static int maxArea(int[] height){
        int i=0,j=height.length-1;
        int max=0;
        while(i<j){
            if(height[i]<height[j]){
                max=Math.max(max,height[i]*(j-i));
                i++;
            }else{
                max=Math.max(max,height[j]*(j-i));
                j--;
            }
        }
        return max;
    }
}
