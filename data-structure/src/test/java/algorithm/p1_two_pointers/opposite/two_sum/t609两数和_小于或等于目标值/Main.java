package algorithm.p1_two_pointers.opposite.two_sum.t609两数和_小于或等于目标值;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/609/description
 * 给定一个整数数组，找出这个数组中有多少个不同的下标对，满足下标对中的两个下标所对应元素之和小于或等于目标值。返回下标对数。
 *
 * @author aabo
 * @createTime 2022/6/11 23:02
 */
public class Main {

    @Test
    public void test() {
        int[] nums = {2, 7, 11, 15};
        int target = 24;

        System.out.println(twoSum5ByTwoPointer(nums, target));
//        System.out.println(twoSum5ByHashMap(nums, target));
    }

    /**
     * @param nums:   an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5ByTwoPointer(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return 0;
        }
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0, right = n - 1;
        int result = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            // left每右移一次 就有right-left对满足条件的下标
            if (sum <= target) {
                result += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return result;

    }

    /**
     * @param nums:   an array of integer
     * @param target: an integer
     * @return: an integer
     */
//    public int twoSum5ByHashMap(int[] nums, int target) {
//
//        if (nums == null || nums.length < 2) {
//            return 0;
//        }
//        int n = nums.length;
//        Map<Integer, Integer> visited = new TreeMap<>();
//        int result = 0;
//        for (int i = 0; i < n; i++) {
//            int count = visited.getOrDefault(target - nums[i], 0);
//
//            if (count > 0) {
//                visited.put(target - nums[i], count - 1);
//                result++;
//            } else {
//                visited.put(nums[i], visited.getOrDefault(nums[i], 0) + 1);
////                System.out.println(visited.get(nums[i]));
//            }
//        }
//        return result;
//
//    }

}
