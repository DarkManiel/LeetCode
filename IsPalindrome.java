/**
 * Created by markdaniel on 8/28/15.
 */
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        ListNode lag = head;
        ListNode ref = head;

        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }

        ListNode firstHalf = null;
        for (int i = 0; i < len / 2; i++) {
            ListNode temp = new ListNode(lag.val);
            temp.next = firstHalf;
            firstHalf = temp;
            lag = lag.next;
        }

        if (len % 2 == 1) {
            lag = lag.next;
        }

        while (lag != null) {
            if (lag.val != firstHalf.val) {
                return false;
            }
            lag = lag.next;
            firstHalf = firstHalf.next;
        }
        return true;
    }
}
