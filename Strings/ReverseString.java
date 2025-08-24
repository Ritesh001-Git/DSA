public class ReverseString {
    public void reverseString(char[] s) {
    //Initialize two pointers: one at the beginning, one at the end
            int i= 0, j = s.length - 1;
            while (i < j) {// Continue swapping until both pointers meet in the middle
                // Swap characters
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
            } // End of while loop
            
        }
        
        public static void main(String[] args) {
                ReverseString rs = new ReverseString();
                char[] s = {'h', 'e', 'l', 'l', 'o'};
                rs.reverseString(s);
                System.out.println(s);
        }
    }