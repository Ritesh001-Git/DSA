public class RotateList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2; // Rotate the list to the right by 2 places
        ListNode result = rotateRight(head, k);
        printList(result); // Output: 4 -> 5 -> 1 -> 2 -> 3
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
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        int l=0,i=1;
        ListNode p=head;
        while(p!=null){
            l++;
            p=p.next;
        }
        k=k%l;
        if (k==0) return head;
        l=l-k;
        p=head;
        while(i<l){
            p=p.next;
            i++;
        }
        ListNode temp=p.next;
        p.next=null;
        p=temp;
        while(p.next!=null){
            p=p.next;
        }
        p.next=head;
        head=temp;
        return head;
    }
}
