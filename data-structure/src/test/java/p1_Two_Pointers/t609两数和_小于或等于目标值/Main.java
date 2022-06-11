package p1_Two_Pointers.t609两数和_小于或等于目标值;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
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
