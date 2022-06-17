package p2_dichotomy.t460在排序数组中找最接近的K个数;

/**
 * https://www.lintcode.com/problem/460
 * 给一个目标数 target, 一个非负整数 k, 一个按照升序排列的数组 A。
 * 在A中找与target最接近的k个整数。
 * 返回这k个数并按照与target的接近程度从小到大排序，如果接近程度相当，那么小的数排在前面。
 * Created by IntelliJ IDEA.
 *
 * @author aabo
 * @createTime 2022/6/15 21:49
 */
public class Main {
    /**
     * @param A:      an integer array
     * @param target: An integer
     * @param k:      An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {

        // 找到比 target 小的最右一个数
        int left = findUpperClosest(A, target);
        int right = left + 1;

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            // 左边更接近
            if (isLeftCloser(A, left, right, target)) {
                result[i] = A[left];
                left--;
            } else {
                result[i] = A[right];
                right++;
            }
        }

        return result;
    }

    // 判断是否是左边的数更接近 target
    private boolean isLeftCloser(int[] nums, int left, int right, int target) {

        if (left < 0) {
            return false;
        }
        if (right >= nums.length) {
            return true;
        }

        return target - nums[left] <= nums[right] - target;

    }

    // 找到比 target 小的最右一个数
    private int findUpperClosest(int[] nums, int target) {

        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[end] < target) {
            return end;
        }
        if (nums[start] < target) {
            return start;
        }
        return -1;

    }

}
