package p5_dfs.permutation.t16带重复元素的排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/16
 * 给出一个具有重复数字的列表，找出列表所有不同的排列。
 * 有重复元素
 *
 * @author aabo
 * @createTime 2022/6/17 16:28
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        dfs(nums, new boolean[n], new ArrayList<>());

    }

    private static void dfs(int[] nums, boolean[] visited, List<Integer> item) {

        if (nums.length == item.size()) {
            System.out.println(item);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            // 重复的数，前面的还没选就不能去选后面的
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
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
