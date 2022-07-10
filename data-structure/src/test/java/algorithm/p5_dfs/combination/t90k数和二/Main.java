package algorithm.p5_dfs.combination.t90k数和二;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/90
 * 给定 n 个不同的正整数，整数 k（1<=k<=n1<=k<=n）以及一个目标数字。
 * 在这 n 个数里面找出 k 个不同的数，使得这 k 个数的和等于目标数字，你需要找出所有满足要求的方案（方案顺序不作要求）。
 *
 * @author aabo
 * @createTime 2022/6/17 15:56
 */
public class Main {
    /**
     * @param A:      an integer array
     * @param k:      a postive integer <= length(A)
     * @param target: an integer
     * @return: A list of lists of integer
     */
    public List<List<Integer>> kSumII(int[] A, int k, int target) {

        List<List<Integer>> results = new ArrayList<>();
        dfs(A, k, target, 0, 0, new ArrayList<>(), results);
        return results;
    }

    private void dfs(int[] A,
                     int k,
                     int target,
                     int cur,
                     int sum,
                     List<Integer> path,
                     List<List<Integer>> results) {

        if (path.size() == k) {
//            System.out.println("path = " + path);
            if (sum == target) {
                results.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = cur; i < A.length; i++) {
            path.add(A[i]);
            dfs(A, k, target, i + 1, sum + A[i], path, results);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        System.out.println(new Main().kSumII(nums, 2, 5));
    }

}