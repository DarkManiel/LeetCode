__author__ = 'markdaniel'
class MergeSortedArray(object):
    def merge(self, nums1, m, nums2, n):
        for x in xrange(len(nums1) - 1,m - 1, -1):
            nums1.pop(x)
        i = 0
        j = 0
        while (i < m and j < n):
            if (nums1[i] <= nums2[j]) :
                i += 1
            else:
                nums1.insert(i, nums2[j])
                j += 1
                i += 1
                m += 1

        for x in xrange(j, n):
                nums1.append(nums2[x])


if __name__ == '__main__':
    arr1 = [1]
    # arr1.append(1)
    # arr1.append(2)
    # arr1.append(4)
    arr2 = [0]
    arr2.append(3)
    # arr2.append(5)

    MergeSortedArray().merge(arr1, 1, arr2, 5)
    print(arr1)
