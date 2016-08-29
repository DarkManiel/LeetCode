/**
 * Created by markdaniel on 8/25/15.
 */
public class SearchRange {
    public static void main(String[] args) {
//        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] nums = {1};
        int[] res = searchRange(nums, 0);
        System.out.println("ANSWER: " + res[0] + " " + res[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            return (nums[0] == target) ? new int[]{0, 0} : new int[]{-1, -1};
        }
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public static int[] binarySearch(int[] nums, int target, int lo, int hi) {
        if (hi == lo) {
            if (nums[lo] == target) {
                return new int[]{lo, hi};
            } else {
                return new int[]{-1, -1};
            }
        }
        int[] result = {-1, -1};

        int[] leftResult = {-1, -1};
        int leftMid = (hi - lo) / 2 + lo;
        int rightMid = (hi - lo) / 2 + lo + 1;
        if (nums[leftMid] == target) {
            boolean foundEndpoint = false;
            int index = leftMid;
            while (!foundEndpoint && index >= lo) {
                if (nums[index] != target) {
                    result[0] = index + 1;
                    foundEndpoint = true;
                }
                index--;
            }
            if (!foundEndpoint) {
                result[0] = index + 1;
            }
            result[1] = leftMid;
        } else if (nums[leftMid] > target) {

            leftResult = binarySearch(nums, target, lo, leftMid);
            if (leftResult[0] != -1) {
                result[0] = leftResult[0];
            }
        }

        if (nums[rightMid] == target) {
            boolean foundEndpoint = false;
            int index = rightMid;
            while (!foundEndpoint && index <= hi) {
                if (nums[index] != target) {
                    result[1] = index - 1;
                    foundEndpoint = true;
                }
                index++;
            }
            if (!foundEndpoint) {
                result[1] = index - 1;
            }
            if (result[0] == -1) {
                result[0] = rightMid;
            }
        } else if (result[1] == -1 && nums[rightMid] < target) {
            int[] rightResult = binarySearch(nums, target, rightMid, hi);
            if (rightResult[1] != -1) {
                result[1] = rightResult[1];
            }
            if (result[0] == -1 && rightResult[0] != -1) {
                result[0] = rightResult[0];
            }
        }
        if (result[1] == -1 && leftResult[1] != -1) {
            result[1] = leftResult[1];
        }
        return result;
    }
}
