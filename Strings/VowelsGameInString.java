public class VowelsGameInString {
    public static void main(String[] args) {
        String s = "aeiou";
        System.out.println(doesAliceWin(s));
    }
    public static boolean doesAliceWin(String s) {
        for(char ch:s.toCharArray()){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                return true;
            }
        }
        return false;
    }
}
