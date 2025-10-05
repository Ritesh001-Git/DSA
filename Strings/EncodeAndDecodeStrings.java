import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {
    public static void main(String[] args) {
        List<String> strs = Arrays.asList("Hello", "World", "", "This is a test", "Java//~is//~fun");
        String encoded = encode(strs);
        System.out.println("Encoded: " + encoded);
        List<String> decoded = new EncodeAndDecodeStrings().decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
    public static String encode(List<String> strs) {
        if(strs.isEmpty()) return "#EMPTY#";
        StringBuilder s=new StringBuilder();
        for(int i=0; i<strs.size(); i++){
            s.append(strs.get(i));
            if(i!=strs.size()-1) s.append("//~");
        }
        return s.toString();
    }

    public List<String> decode(String str) {
        if(str.equals("#EMPTY#")) return new ArrayList<>();
        if(str.length()==0) return Arrays.asList("");
        return Arrays.asList(str.split("//~", -1));

    }
}
