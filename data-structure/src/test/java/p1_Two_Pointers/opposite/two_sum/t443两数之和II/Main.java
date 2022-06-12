package p1_Two_Pointers.opposite.two_sum.t443两数之和II;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/443
 * 给一组整数，问能找出多少对整数，他们的和大于一个给定的目标值。请返回答案。
 *
 * @author aabo
 * @createTime 2022/6/12 0:07
 */
public class Main {

    @Test
    public void test() {

    }

    /**
     * @param nums:   an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2ByTwoPointer(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = n - 1;
        int result = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            // right每左移一次 就有right-left对满足条件的下标
            if (sum > target) {
                result += (right - left);
                right--;
            } else {
                left++;
            }
        }
        return result;

    }

}
