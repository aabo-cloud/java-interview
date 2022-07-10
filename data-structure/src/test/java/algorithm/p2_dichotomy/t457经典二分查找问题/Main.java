package algorithm.p2_dichotomy.t457经典二分查找问题;

/**
 * [daɪˈkɑːtəmi]
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/457
 * 在一个排序数组中找一个数，返回该数出现的任意位置，如果不存在，返回 -1。
 *
 * @author aabo
 * @createTime 2022/6/15 21:48
 */
public class Main {
    /**
     * @param nums:   An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {

            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }

        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;

    }
}