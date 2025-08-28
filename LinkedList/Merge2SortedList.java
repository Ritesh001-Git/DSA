public class Merge2SortedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        ListNode mergedList = mergeTwoLists(l1, l2);
        printList(mergedList); // Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6
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
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p=new ListNode(0);
        ListNode q=p;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                q.next=list1;
                q=q.next;
                list1=list1.next;
            }else{
                q.next=list2;
                q=q.next;
                list2=list2.next;
            }
        }
        while(list1!=null){
            q.next=list1;
            q=q.next;
            list1=list1.next;
        }
        while(list2!=null){
            q.next=list2;
            q=q.next;
            list2=list2.next;
        }
        return p.next;
    }
}
