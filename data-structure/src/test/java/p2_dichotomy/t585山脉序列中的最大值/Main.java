package p2_dichotomy.t585山脉序列中的最大值;

import org.junit.Test;

/**
 * start + 1 < end
 * start + end + 1 < 2end
 * (start + end) / 2 < (2end - 1) / 2
 * mid < end
 *
 * https://www.lintcode.com/problem/585
 * 给 n 个整数的山脉数组，即先增后减的序列，找到山顶（最大值）。
 * 数组严格递增，严格递减
 *
 * Created by IntelliJ IDEA.
 * @author aabo
 * @createTime 2022/6/15 22:20
 *
 */
public class Main {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
//            System.out.println(mid + 1);
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else if (nums[mid] < nums[mid - 1]) {
                end = mid;
            }
        }

        return Math.max(nums[start], nums[end]);
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        System.out.println(mountainSequence(nums));
    }

}