public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0, 6, 5};
        System.out.println("Array: " + java.util.Arrays.toString(arr));
        int peakIndex = findPeakElement(arr);
        if (peakIndex != -1) {
            System.out.println("Peak Element: " + arr[peakIndex] + " at index " + peakIndex);
        } else {
            System.out.println("No peak element found.");
        }
    }
    public static int findPeakElement(int[] arr) {
        if(arr.length==1) return 0;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i]>arr[i+1]) return i;
        }
        return arr.length-1;
    }
}
