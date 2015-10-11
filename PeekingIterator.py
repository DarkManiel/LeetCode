__author__ = 'markdaniel'
# Below is the interface for Iterator, which is already defined for you.
#
# class Iterator(object):
#     def __init__(self, nums):
#         """
#         Initializes an iterator object to the beginning of a list.
#         :type nums: List[int]
#         """
#
#     def hasNext(self):
#         """
#         Returns true if the iteration has more elements.
#         :rtype: bool
#         """
#
#     def next(self):
#         """
#         Returns the next element in the iteration.
#         :rtype: int
#         """

class PeekingIterator(object):
    def __init__(self, iterator):
        """
        Initialize your data structure here.
        :type iterator: Iterator
        """
        self.iterator = iterator
        self.is_peeking = False
        self.cache = None



    def peek(self):
        """
        Returns the next element in the iteration without advancing the iterator.
        :rtype: int
        """
        if not self.is_peeking:
            self.is_peeking = True
            self.cache = self.iterator.next()
            return self.cache
        return self.cache


    def next(self):
        """
        :rtype: int
        """
        if self.is_peeking:
            cache_copy = self.cache
            self.is_peeking = False
            self.cache = None
            return cache_copy
        return self.iterator.next()

    def hasNext(self):
        """
        :rtype: bool
        """
        if self.is_peeking:
            return True
        try:
            self.cache = self.iterator.next()
            self.is_peeking = True
            return True
        except:
            return False

# Your PeekingIterator object will be instantiated and called as such:
# iter = PeekingIterator(Iterator(nums))
# while iter.hasNext():
#     val = iter.peek()   # Get the next element but not advance the iterator.
#     iter.next()         # Should return the same value as [val].
if __name__ == '__main__':
    iterator = iter([1,2,3,4])

    # [0,1,1,2,2,1,1,2,0,1,0,2,0]
    peekiter = PeekingIterator(iterator)
    print(peekiter.hasNext())
    print(peekiter.peek())
    print(peekiter.next())
    print(peekiter.hasNext())
    print(peekiter.peek())
    print(peekiter.next())
    print(peekiter.hasNext())
    print(peekiter.next())
    print(peekiter.hasNext())
    print(peekiter.peek())
    print(peekiter.hasNext())
    print(peekiter.next())
    print(peekiter.hasNext())
