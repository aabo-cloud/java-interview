package p1_Two_Pointers.opposite.two_sum.t58四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private List<List<Integer>> results = new ArrayList<>();

    /**
     * @param numbers: Give an array
     * @param target:  An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length < 4) {
            return results;
        }

        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 3; i++) {

            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < numbers.length - 2; j++) {
                if (j > i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                int lastTwoSum = target - numbers[i] - numbers[j];
                int twoSumLeft = j + 1, twoSumRight = numbers.length - 1;
                twoSum(numbers, i, j, twoSumLeft, twoSumRight, lastTwoSum);
            }

        }

        return results;
    }

    private void twoSum(int[] nums, int first, int second, int twoSumLeft, int twoSumRight, int target) {

        while (twoSumLeft < twoSumRight) {
            int twoSum = nums[twoSumLeft] + nums[twoSumRight];
            if (twoSum == target) {
                getQuadruplet(nums, first, second, twoSumLeft, twoSumRight);
                twoSumLeft++;
                twoSumRight--;
                while (twoSumLeft < twoSumRight && nums[twoSumLeft] == nums[twoSumLeft - 1]) {
                    twoSumLeft++;
                }
                while (twoSumLeft < twoSumRight && nums[twoSumRight] == nums[twoSumRight + 1]) {
                    twoSumRight--;
                }
            } else if (twoSum < target) {
                twoSumLeft++;
            } else {
                twoSumRight--;
            }
        }

    }

    private void getQuadruplet(int[] nums, int first, int second, int third, int fourth) {
        List<Integer> quadruplet = new ArrayList<>();
        quadruplet.add(nums[first]);
        quadruplet.add(nums[second]);
        quadruplet.add(nums[third]);
        quadruplet.add(nums[fourth]);
        results.add(quadruplet);
    }

}