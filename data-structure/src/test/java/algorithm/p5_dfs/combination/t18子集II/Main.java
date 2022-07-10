package algorithm.p5_dfs.combination.t18子集II;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/18
 * 给定一个可能具有重复数字的列表，返回其所有可能的子集。
 * <p>
 * 子集中的每个元素都是非降序的
 * 两个子集间的顺序是无关紧要的
 * 解集中不能包含重复子集
 *
 * @author aabo
 * @createTime 2022/6/17 15:32
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        dfs(0, nums, new ArrayList<>());
    }

    private static void dfs(int cur, int[] nums, List<Integer> item) {
        System.out.println(item);
        for (int i = cur; i < nums.length; i++) {
            // 如果选择了前一个元素的话，i == cur
            // i > cur 就说明肯定没有选择前一个元素
            if (i > 0 && nums[i - 1] == nums[i] && i > cur) {
                continue;
            }
            item.add(nums[i]);
            dfs(i + 1, nums, item);
            item.remove(item.size() - 1);
        }
    }

}
