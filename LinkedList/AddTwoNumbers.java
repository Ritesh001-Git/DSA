

class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        printList(result); // Output: 7 -> 0 -> 8
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode p=dummy;
        int carry=0;
        while(l1 != null || l2 != null){
            int sum=carry;
            if(l1 != null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            carry=sum/10;
            p.next=new ListNode(sum%10);
            p=p.next;
        }
        if(carry==1){
            p.next=new ListNode(1);
        }
        return dummy.next;
    }
}
