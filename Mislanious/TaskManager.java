import java.util.*;
public class TaskManager {
    // taskId -> [userId, priority]
   Map<Integer, int[]> taskMap;
   // (priority desc, taskId asc) -> taskId
   TreeMap<int[], Integer> pq;
   public TaskManager(List<List<Integer>> tasks) {
       taskMap=new HashMap<>();
       pq=new TreeMap<>((a,b)->{
           if(a[1] != b[1]) return b[1]-a[1];
           return b[0]-a[0];
       }
       );
       initializeTasks(tasks);
   }

   private void initializeTasks(List<List<Integer>> tasks) {
       for (List<Integer> t : tasks) {
           add(t.get(0), t.get(1), t.get(2));
       }
   }
   
   public void add(int userId, int taskId, int priority) {
       taskMap.put(taskId,new int[]{userId,priority});
       pq.put(new int[]{taskId,priority},taskId);
   }
   
   public void edit(int taskId, int newPriority) {
       int[] old=taskMap.get(taskId);
       pq.remove(new int[]{taskId,old[1]});
       taskMap.put(taskId,new int[]{old[0],newPriority});
       pq.put(new int[]{taskId,newPriority},taskId);
   }
   
   public void rmv(int taskId) {
       int[] old=taskMap.remove(taskId);
       if (old != null) pq.remove(new int[]{taskId,old[1]});
   }
   
   public int execTop() {
       if(pq.isEmpty())return -1;
       int taskId=pq.firstEntry().getValue();
       int userId=taskMap.get(taskId)[0];
       rmv(taskId);
       return userId;
   }
   public static void main(String[] args) {
         List<List<Integer>> tasks = new ArrayList<>();
         tasks.add(Arrays.asList(1, 101, 5));
         tasks.add(Arrays.asList(2, 102, 3));
         tasks.add(Arrays.asList(3, 103, 4));
         
         TaskManager tm = new TaskManager(tasks);
         
         System.out.println("Executing top task assigned to user: " + tm.execTop()); // Should be userId 1
         
         tm.edit(102, 6); // Change priority of taskId 102 to 6
         System.out.println("Executing top task assigned to user: " + tm.execTop()); // Should be userId 2
         
         tm.rmv(103); // Remove taskId 103
         System.out.println("Executing top task assigned to user: " + tm.execTop()); // Should be -1 (no tasks left)
   }
}