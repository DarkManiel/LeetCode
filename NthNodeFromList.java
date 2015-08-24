/**
 * Created by markdaniel on 8/23/15.
 */
public class NthNodeFromList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
        ListNode head = removeNthFromEnd(node, 1);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode lag = head;
        ListNode lead = head;
        int count = 0;
        while (lead != null) {
            if (count > n) {
                lag = lag.next;
            }
            lead = lead.next;
            count ++;
        }

        if (count > n) {
            lag.next = lag.next.next;
        } else if (count == n){
            return head.next;
        } else {
            return null;
        }
        return head;
    }
}
