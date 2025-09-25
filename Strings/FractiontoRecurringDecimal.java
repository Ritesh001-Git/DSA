import java.util.HashMap;
import java.util.Map;

public class FractiontoRecurringDecimal {
    public static void main(String[] args) {
        int numerator = 4, denominator = 333;
        System.out.println(fractionToDecimal(numerator, denominator)); // Output: "0.(012)"
    }
    public static String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        StringBuilder r=new StringBuilder();
        if((numerator<0)^(denominator<0)) r.append("-");
        long n=Math.abs((long)numerator);
        long d=Math.abs((long)denominator);

        r.append(n/d);
        long remainder=n%d;
        if(remainder==0) return r.toString();

        r.append(".");
        Map<Long,Integer> mp=new HashMap<>();
        while(remainder!=0){
            if(mp.containsKey(remainder)){
                int index=mp.get(remainder);
                r.insert(index,"(");
                r.append(")");
                return r.toString();
            }
            mp.put(remainder,r.length());
            remainder*=10;
            r.append(remainder/d);
            remainder%=d;
        }
        return r.toString();
    }
}
