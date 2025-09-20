import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Router {
    Queue<int[]> q;
    int limit;
     Set<String> s=new HashSet<>();
    public Router(int memoryLimit) {
        q=new LinkedList<>();
        limit=memoryLimit;
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        int[] a={source,destination,timestamp};
        String key=Arrays.toString(a);
        if(s.contains(key)) return false;
        if(q.size()>=limit){
            int[] removed=q.poll();
            s.remove(Arrays.toString(removed));
        }
        q.add(a);
        s.add(key);
        return true;
    }
    
    public int[] forwardPacket() {
        if(q.isEmpty()) return new int[0];
        int[] temp=q.poll();
        s.remove(Arrays.toString(temp));
        return temp;
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        int c=0;
        for(int[] i:q){
            if(i[1]==destination && i[2]>=startTime && i[2]<=endTime) c++;
        }
        return c;
    }
    public static void main(String[] args) {
        Router router = new Router(3);
        System.out.println(router.addPacket(1, 2, 100)); // true
        System.out.println(router.addPacket(2, 3, 200)); // true
        System.out.println(router.addPacket(1, 2, 100)); // false (duplicate)
        System.out.println(router.addPacket(3, 4, 300)); // true
        System.out.println(router.addPacket(4, 5, 400)); // true (removes oldest packet)
        System.out.println(Arrays.toString(router.forwardPacket())); // [2, 3, 200]
        System.out.println(router.getCount(2, 50, 150)); // 1
        System.out.println(router.getCount(3, 100, 300)); // 0
    }
}
