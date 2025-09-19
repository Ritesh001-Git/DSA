import java.util.*;

public class SpreadSheet {
    public static Map<String, Integer> mp;
    
    public SpreadSheet(int rows) {
        mp = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        mp.put(cell, value);
    }
    
    public void resetCell(String cell) {
        mp.put(cell, 0);
    }
    
    public int getValue(String formula) {
        formula = formula.substring(1);
        String[] r = formula.split("\\+");
        String left = r[0];
        String right = r[1];
        return getOperandValue(left) + getOperandValue(right);
    }
    
    private static int getOperandValue(String s) {
        if (Character.isDigit(s.charAt(0))) {
            return Integer.parseInt(s);
        } else {
            Integer value = mp.get(s);
            return value != null ? value : 0;
        }
    }
    
    public static void main(String[] args) {
        SpreadSheet obj = new SpreadSheet(3);
        obj.setCell("A1", 5);
        obj.setCell("B2", 3);
        int param_3 = obj.getValue("=A1+B2");
        System.out.println(param_3);
        obj.resetCell("A1");
        int param_4 = obj.getValue("=A1+10");
        System.out.println(param_4);
    }
}