package p5_dfs.permutation.t15全排列;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/15
 * 给定一个数字列表，返回其所有可能的排列。
 * 你可以假设没有重复数字。
 *
 * @author aabo
 * @createTime 2022/6/17 16:25
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        dfs(nums, new boolean[n], new ArrayList<>());

    }

    private static void dfs(int[] nums, boolean[] visited, List<Integer> item) {
        if (item.size() == nums.length) {
            System.out.println(item);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            item.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, item);
            visited[i] = false;
            item.remove(item.size() - 1);
        }
    }


}
