from Src.ListNode import ListNode

__author__ = 'markdaniel'
class Solution(object):
    def reverseKGroup(self, head, k):
        # clunky but working solution.... need to simplify and modularize
        if k < 2 or head is None:
            return head
        res = head
        hasResetHead = False
        lag = head
        i = 1
        stitcher = None
        while head is not None:
            if i == k and not hasResetHead:
                res = head
                hasResetHead = True
            if (i - 1) % k == 0 and i is not 1:
                temp = lag.next
                lag.next = head
                tempStitcher = lag
                for x in xrange(1, k):
                    tempOldNext = temp.next
                    temp.next = lag
                    lag = temp
                    temp = tempOldNext
                if stitcher is not None:
                    stitcher.next = lag
                stitcher = tempStitcher
                lag = head
            i += 1
            head = head.next
        if i % k == 1:
            prev = lag
            next = lag.next
            x = 0
            while next is not None:
                temp = next.next
                next.next = prev
                if x == 0:
                    next.next.next = None
                prev = next
                next = temp
                x += 1
            if stitcher is not None:
                stitcher.next = prev
        return res

if __name__ == '__main__':
    k = 2
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    # head.next.next.next.next = ListNode(5)

    sol = Solution().reverseKGroup(head, k)

    while sol is not None:
        print(sol.val)
        sol = sol.next