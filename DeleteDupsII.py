from Src.ListNode import ListNode

__author__ = 'markdaniel'
class DeleteDupsII(object):
    def deleteDuplicates(self, head):
        """
        :param head:
        :return:
        """
        if head is None or head.next is None:
            return head
        cur = head.val
        lag = head
        lead = head
        while lead is not None and lead.next is not None:
            cur = lead.val
            if lead.next.val == cur:
                while lead is not None and lead.val == cur:
                    lead = lead.next
                if head.val == cur:
                    head = lead
                else:
                    lag.next = lead
            else:
                lag = lead
                if lead is None:
                    lead = None
                else:
                    lead = lead.next
        return head

if __name__ == '__main__':
    head = ListNode(1)
    head.next = ListNode(1)
    head.next.next = ListNode(2)
    head.next.next.next = ListNode(2)
    # head.next.next.next.next= ListNode(3)
    # while head != None:
    #     print(head.val)
    #     head = head.next

    res = DeleteDupsII().deleteDuplicates(head)
    while res != None:
        print(res.val)
        res = res.next