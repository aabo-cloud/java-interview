package algorithm.p2_dichotomy.t159寻找旋转排序数组中的最小值;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/159
 * 假设一个按升序排好序的数组在其某一未知点发生了旋转
 * （比如0 1 2 4 5 6 7 可能变成4 5 6 7 0 1 2）。
 * 你需要找到其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 *
 * @author aabo
 * @createTime 2022/6/15 22:25
 */
public class Main {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // 如果 mid > end，起点在右边，抛弃左边
            if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return Math.min(nums[start], nums[end]);
    }
}