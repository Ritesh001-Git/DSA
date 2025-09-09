public class ZigzagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String result = convert(s, numRows);
        System.out.println("Zigzag Conversion: " + result); // Output: "PAHNAPLSIIGYIR"
    }
    public static String convert(String s, int numRows) {
        if (numRows==1 || numRows>=s.length()) {
            return s;
        }
        StringBuilder r=new StringBuilder();
        int len=(numRows-1)*2;
        for(int i=0; i<numRows; i++){
            for(int j=0; j+i<s.length(); j+=len){
                r.append(s.charAt(j+i));
                int diag=j+len-i;
                if(i!=0 && i!=numRows-1 && diag<s.length()){
                    r.append(s.charAt(diag));
                }
            }  
        }
        return r.toString();
    }
}
