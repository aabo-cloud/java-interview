package algorithm.p1_two_pointers.opposite.partition.t31数组划分;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/31
 * 给出一个整数数组 nums 和一个整数 k。划分数组（即移动数组 nums 中的元素），使得：
 * <p>
 * 所有小于k的元素移到左边
 * 所有大于等于k的元素移到右边
 * 返回数组划分的位置，即数组中第一个位置 i，满足 nums[i] 大于等于 k。
 *
 * @author aabo
 * @createTime 2022/6/13 13:01
 */
public class Main {
    /**
     * @param nums: The integer array you should partition
     * @param k:    An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0, right = nums.length - 1;

        while (left <= right) {

            while (left <= right && nums[left] < k) {
                left++;
            }
            while (left <= right && nums[right] >= k) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }

        }

        return left;

    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 1};
//        1, 2, 2, 3
//
        System.out.println(new Main().partitionArray(nums, 2));
    }

}