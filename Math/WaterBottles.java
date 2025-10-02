public class WaterBottles {
    public static void main(String[] args) {
        int numBottles = 9;
        int numExchange = 3;
        System.out.println(numWaterBottles(numBottles, numExchange));
    }
    public static int numWaterBottles(int numBottles, int numExchange) {
        int c=numBottles;
        while(numBottles>=numExchange){
            int t=numBottles/numExchange;
            c+=t;
            int remain=numBottles%numExchange;
            numBottles=(numBottles/numExchange)+remain;
        }
        return c;
    }
}
