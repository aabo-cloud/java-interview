package p1_Two_Pointers.same.t610两数和_差等于目标值;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/610
 * 给定一个排序后的整数数组，找到两个数的 差 等于目标值。
 * 你需要返回一个包含两个数字的列表 [num1, num2], 使得 num1 与 num2 的差为 target，同时 num1 必须小于 num2。
 *
 * @author aabo
 * @createTime 2022/6/12 14:05
 */
public class Main {

    /**
     * @param nums:   an array of Integer
     * @param target: an integer
     * @return: [num1, num2] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return new int[0];
        }
//        Arrays.sort(nums);
        int left = 0, right = 1;
        target = Math.abs(target);
        for (; left < nums.length; left++) {
            right = Math.max(right, left + 1);
            while (right < nums.length && nums[right] - nums[left] < target) {
                right++;
            }
            if (right >= nums.length) {
                break;
            }
            if (nums[right] - nums[left] == target) {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[0];

    }

}
