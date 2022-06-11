package p1_Two_Pointers.t56两数之和;

import header.ListItem;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.lintcode.com/problem/56/description
 * Created by IntelliJ IDEA.
 *
 * @author aabo
 * @createTime 2022/6/11 20:36
 */
@Slf4j
public class Main {

    @Test
    public void test() {

        int[] numbers = {0, 10, 2, 3, 4, 5, 6};

        Assert.assertArrayEquals(new int[]{0, 5}, twoSumByTwoPointer(numbers, 5));
        System.out.println(Arrays.toString(twoSumByTwoPointer(numbers, 9)));
        System.out.println(Arrays.toString(twoSumByTwoPointer(numbers, 11)));

    }

    /**
     * @param numbers: An array of Integer
     * @param target:  target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSumByTwoPointer(int[] numbers, int target) {

        int n = numbers.length;
        ListItem<Integer>[] list = new ListItem[n];

        for (int i = 0; i < n; i++) {
//            list[i] = (ListItem.<Integer>builder().index(i).data(numbers[i]).build());
            list[i] = new ListItem<>(i, numbers[i]);
        }

        Arrays.sort(list);

        int left = 0, right = n - 1;

        while (left < right) {
            int sum = list[left].data + list[right].data;
            if (sum == target) {
                return new int[]{Math.min(list[left].index, list[right].index), Math.max(list[left].index, list[right].index)};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return null;

    }

    /**
     * @param numbers: An array of Integer
     * @param target:  target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSumByHashSet(int[] numbers, int target) {

        if (numbers == null || numbers.length < 2) {
            return null;
        }
        int n = numbers.length;

        Map<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (visited.containsKey(target - numbers[i])) {
                return new int[]{visited.get(target - numbers[i]), i};
            }
            visited.put(numbers[i], i);
        }

        return null;

    }


}
