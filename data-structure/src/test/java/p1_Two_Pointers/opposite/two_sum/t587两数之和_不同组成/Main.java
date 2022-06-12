package p1_Two_Pointers.opposite.two_sum.t587两数之和_不同组成;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/587
 * 给一整数数组, 找到数组中有多少组 不同的元素对 有相同的和, 且和为给出的 target 值, 返回对数.
 *
 * @author aabo
 * @createTime 2022/6/12 13:22
 */
public class Main {

    /**
     * @param nums:   an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6ByTwoPointer(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = n - 1;

        int result = 0;
        while (left < right) {

            int sum = nums[left] + nums[right];
            if (sum == target) {
                result++;
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (sum < target) {
                left++;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            } else {
                right--;
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            }

        }
        return result;

    }

    /**
     * @param nums:   an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6ByHashMap(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return 0;
        }
        int result = 0;
        Map<Integer, Integer> visited = new HashMap<>();
        for (int num : nums) {
            if (visited.getOrDefault(target - num, 1) == 0) {
                visited.put(target - num, 1);
                visited.put(num, 1);
                result++;
            } else {
                if (visited.containsKey(num)) {
                    continue;
                }
                visited.put(num, 0);
            }
        }
        return result;

    }

    @Test
    public void test() {

        int[] nums = {107, 0, 107, 0, 107, 0, 0, 0, 0, 0, 0, 0, 0, 107, 0, 107, 107, 106, 1, 1, 9, 98, 9, 97, 11, 1001, 2001, -91,
                201, 203, 201, 999, 345, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 5, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 101, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = 107;

        System.out.println(twoSum6ByHashMap(nums, target));

    }

}
