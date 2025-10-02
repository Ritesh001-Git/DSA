public class WaterBottles2 {
    public static void main(String[] args) {
        int numBottles = 20;
        int numExchange = 3;
        System.out.println(maxBottlesDrunk(numBottles, numExchange));
    }
    public static int maxBottlesDrunk(int numBottles,int numExchange){
        int n=numBottles,empty=numBottles;
        while(numExchange<=empty){
            empty-=numExchange;
            empty++;
            numExchange++;
            n++;
        }
        return n;
    }

}
