public class MinimumTimetoMakeRopeColorful {
    public static void main(String[] args) {
        String colors = "AABABBA";
        int[] neededTime = {1,2,3,4,5,6,7};
        System.out.println(minCost(colors, neededTime)); // Output: 6
    }
    public static int minCost(String colors, int[] neededTime) {
        int n=0;
        for(int i=1; i<colors.length(); i++){
            if(colors.charAt(i)==colors.charAt(i-1)){
                n+=Math.min(neededTime[i],neededTime[i-1]);
                neededTime[i]=Math.max(neededTime[i],neededTime[i-1]);
            }
        }
        return n;
    }
}
