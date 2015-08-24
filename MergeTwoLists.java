/**
 * Created by markdaniel on 8/23/15.
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
//        node1.next = new ListNode(2);
//        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(2);
//        node2.next = new ListNode(4);
//        node2.next.next = new ListNode(7);
        ListNode head = mergeTwoLists(node2, node1);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {return l2;}
        if (l2 == null) {return l1;}
        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode head1 = l1;
        while (l1 != null && l2 != null) {

            if (l1.next != null ) {
                ListNode l1Next = l1.next;
                if (l1Next.val > l2.val) {
                    ListNode l2Next = l2.next;
                    l1.next = l2;
                    l1.next.next = l1Next;
                    l2 = l2Next;
                }
            } else {
                while (l2 != null) {
                    ListNode l2Next = l2.next;
                    l1.next = l2;
                    l2 = l2Next;
                    l1 = l1.next;
                }
            }
            l1 = l1.next;
        }
        return head1;
    }
}
