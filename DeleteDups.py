from Src.ListNode import ListNode

__author__ = 'markdaniel'
class DeleteDups(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None:
            return head
        cur = head.val
        lag = head
        lead = head.next

        while lead != None:
            if lead.val == cur:
                lag.next = lead.next
                lead = lead.next
            else:
                lag = lead
                lead = lead.next
            cur = lag.val
        return head


if __name__ == '__main__':
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(2)
    # while head != None:
    #     print(head.val)
    #     head = head.next

    res = DeleteDups().deleteDuplicates(head)
    while res != None:
        print(res.val)
        res = res.next

