/**
 * Created by markdaniel on 8/24/15.
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode res = swapPairs(node1);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode lag = head;
        ListNode lead = head.next;
        ListNode ans = (lead != null) ? lead : lag;

        while (lag != null && lead != null) {
            lag.next = null;
            lag.next = lead.next;
            lead.next = lag;
            lag = lag.next;
            if (lag != null) {
                if (lead.next.next.next == null) {
                    lead.next.next = lag;
                    lag = null;
                } else {
                    lead.next.next = lead.next.next.next;
                }
                lead = lead.next.next;
            }
        }
        return ans;
    }
}
