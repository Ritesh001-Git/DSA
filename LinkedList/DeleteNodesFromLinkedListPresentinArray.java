import java.util.HashSet;
import java.util.Set;
public class DeleteNodesFromLinkedListPresentinArray {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int[] arr = {2, 4};

        ListNode modifiedHead = modifiedList(head, arr);
        printList(modifiedHead); // Expected output: 1 -> 3 -> 5
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
    public static ListNode modifiedList(ListNode head, int[] arr) {
        Set<Integer> set=new HashSet<>();
        for(int num: arr){
            set.add(num);
        }
        while(head!=null && set.contains(head.val)) head=head.next;
        if (head==null) {
            return null;
        }
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            if(set.contains(curr.val)){
                if (prev != null) {
                    prev.next = curr.next;
                }
            }else{
                prev=curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
