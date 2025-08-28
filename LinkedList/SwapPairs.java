public class SwapPairs {
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode result = SwapPairs.swapPairs(head);
        printList(result); // Output: 2 -> 1 -> 4 -> 3
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
    
    public static ListNode swapPairs(ListNode head) {
        ListNode p=head;
        if(p==null || p.next==null) return head;
        ListNode q=head.next;
        while(p!=null && q!=null){
            int t=p.val;
            p.val=q.val;
            q.val=t;
            if(q.next==null || q.next.next==null) break;
            q=q.next.next;
            p=p.next.next;
        }
        return head;
    }
}
