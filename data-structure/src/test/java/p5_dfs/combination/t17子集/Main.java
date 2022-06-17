package p5_dfs.combination.t17子集;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/17
 * 给定一个含不同整数的集合，返回其所有的子集。
 * 子集中的元素不能以降序排列，解集不能包含重复的子集。
 *
 * @author aabo
 * @createTime 2022/6/17 14:18
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
            item.add(nums[i]);
            dfs(i + 1, nums, item);
            item.remove(item.size() - 1);
        }

    }


}
