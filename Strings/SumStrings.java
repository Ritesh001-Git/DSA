public class SumStrings {
    public static void main(String[] args) {
        String s="123456";
        System.out.println(isSumString(s));
    }
    public static boolean isSumString(String s){
        int n=s.length();
        for(int i=1; i<n; i++){
            for(int j=1; i+j<n; j++){
                String s1=s.substring(0,i);
                String s2=s.substring(i,i+j);
                String s3=s.substring(i+j);
                if(solve(s1,s2,s3)) return true;
            }
        }
        return false;
    }
    public static boolean solve(String s1,String s2,String s3){
        String sum=addStrings(s1, s2);
        if(sum.length()>s3.length()) return false;
        if(!sum.equals(s3.substring(0,sum.length()))) return false;
        if(sum.length()==s3.length()) return true;
        return solve(s2,sum,s3.substring(sum.length()));

    }
    public static String addStrings(String s1,String s2){
        StringBuilder sb=new StringBuilder();
        int i=s1.length()-1;
        int j=s2.length()-1;
        int carry=0;
        while(i>=0 || j>=0 || carry>0){
            int sum=carry;
            if(i>=0) sum+=s1.charAt(i--)-'0';
            if(j>=0) sum+=s2.charAt(j--)-'0';
            sb.append(sum%10);
            carry=sum/10;
        }
        return sb.reverse().toString();

    }
}
