package p1_two_pointers.opposite.two_sum.t57三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {

        List<List<Integer>> result = new ArrayList<>();

        if (numbers == null || numbers.length < 3) {
            return result;
        }

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int left = i + 1, right = numbers.length - 1;
            int target = -numbers[i];
            twoSum(numbers, left, right, target, result);
        }

        return result;

    }

    private void twoSum(int[] nums, int left, int right, int target, List<List<Integer>> result) {

        while (left < right) {

            int sum = nums[left] + nums[right];
            if (sum == target) {
                generateTriplet(target, nums[left], nums[right], result);
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
            } else {
                right--;
            }

        }

    }

    private void generateTriplet(int target, int leftNum, int rightNum, List<List<Integer>> result) {
        ArrayList<Integer> triplet = new ArrayList<>();
        triplet.add(-target);
        triplet.add(leftNum);
        triplet.add(rightNum);
        result.add(triplet);
    }


}
