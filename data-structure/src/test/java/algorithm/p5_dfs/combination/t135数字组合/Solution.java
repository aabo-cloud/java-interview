package algorithm.p5_dfs.combination.t135数字组合;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/135
 * 给定一个候选数字的集合 candidates 和一个目标值 target。 找到 candidates 中所有的和为 target 的组合。
 * 在同一个组合中, candidates 中的某个数字出现次数不限。
 * <p>
 * 所有数值 (包括 target ) 都是正整数.
 * 返回的每一个组合内的数字必须是非降序的.
 * 返回的所有组合之间可以是任意顺序.
 * 解集不能包含重复的组合.
 *
 * @author aabo
 * @createTime 2022/6/17 16:01
 */
public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:     An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> results = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int candidate : candidates) {
            set.add(candidate);
        }
        List<Integer> nums = new ArrayList<>(set);
        Collections.sort(nums);
        System.out.println("nums = " + nums);
        dfs(nums, target, 0, 0, new ArrayList<>(), results);
        return results;
    }


    private void dfs(List<Integer> nums,
                     int target,
                     int index,
                     int sum,
                     List<Integer> path,
                     List<List<Integer>> results) {

        if (sum == target) {
            results.add(new ArrayList<>(path));
            return;
        }


        for (int i = index; i < nums.size(); i++) {
            if (sum + nums.get(i) > target) {
                continue;
            }
//            if (index > 0 && nums.get(i) < path.get(index - 1)) {
//                continue;
//            }
            path.add(nums.get(i));
//            dfs(nums, target, index + 1, sum + nums.get(i), path, results);
            dfs(nums, target, i, sum + nums.get(i), path, results);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2};
        System.out.println(new Solution().combinationSum(nums, 5));
    }

}
