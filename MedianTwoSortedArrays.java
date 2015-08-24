/**
 * Created by markdaniel on 8/1/15.
 */
public class MedianTwoSortedArrays {

    public static void main(String[] args) {
        int[] ints1 = {3, 4};
        int[] ints2 = {};
        System.out.println(findMedianSortedArrays(ints1, ints2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null || nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }
        int i = 0, j = 0, currentIndex = 0;
        int nums1Length = nums1.length, nums2Length = nums2.length;
        int[] combined = new int[nums1Length + nums2Length];

        while (i < nums1Length || j < nums2Length) {
            int nums1I = i < nums1Length ? nums1[i] : 0, nums2J = j < nums2Length ? nums2[j] : 0;

            if (i >= nums1Length) {
                combined[currentIndex] = nums2J;
                currentIndex ++;
                j ++;
            } else if (j >= nums2Length){
                combined[currentIndex] = nums1I;
                currentIndex ++;
                i ++;
            } else {
                if ( nums1I < nums2J) {
                    combined[currentIndex] = nums1I;
                    currentIndex ++;
                    i ++;
                } else if (nums1I > nums2J) {
                    combined[currentIndex] = nums2J;
                    currentIndex ++;
                    j ++;
                } else {
                    // equal
                    combined[currentIndex] = nums1I;
                    currentIndex ++;
                    combined[currentIndex] = nums2J;
                    currentIndex ++;
                    i ++;
                    j ++;
                }
            }
        }
        for (int in : combined){
            System.out.println(in);
        }
        return calculateMedian(combined);
    }

    private static double calculateMedian(int[] nums) {
        double median = 0;
        if (nums == null || nums.length == 0 ) {
            return 0;
        }
        if (nums.length % 2 == 0) {
            return (0.0 + nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2;
        } else {
            median = nums[nums.length / 2];
        }
        return median;
    }
}
