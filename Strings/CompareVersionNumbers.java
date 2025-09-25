public class CompareVersionNumbers {
    public static void main(String[] args) {
        String version1 = "1.01";
        String version2 = "1.001";
        System.out.println(compareVersion(version1, version2)); // Output: 0
    }
    public static int compareVersion(String version1, String version2) {
        String[] s1=version1.split("\\.");
        String[] s2=version2.split("\\.");
        int i=0,j=0;
        while(i<s1.length || j<s2.length){
            int a=i<s1.length?Integer.parseInt(s1[i]):0;
            int b=j<s2.length?Integer.parseInt(s2[j]):0;
            if (a!=b) return a>b?1:-1;
            i++;
            j++;
        }
        return 0;
    }
}
