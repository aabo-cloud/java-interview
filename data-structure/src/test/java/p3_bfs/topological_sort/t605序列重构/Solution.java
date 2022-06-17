package p3_bfs.topological_sort.t605序列重构;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/605
 * 判断是否序列 org 能唯一地由 seqs重构得出. org是一个由从1到n的正整数排列而成的序列，1 \leq n \leq 10^41≤n≤10^4。
 * 重构表示组合成seqs的一个最短的父序列 (意思是，一个最短的序列使得所有 seqs里的序列都是它的子序列).
 * 判断是否有且仅有一个能从 seqs重构出来的序列，并且这个序列是org。
 * seqs 中可能存在重复序列
 *
 * @author aabo
 * @createTime 2022/6/16 17:23
 */
public class Solution {
    /**
     * @param org:  a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here

//        if (seqs == null || seqs.length == 0) {
//            return false;
//        }
//
//        if (org != null && org.length == 0 && seqs[0] != null && seqs[0].length == 0) {
//            return true;
//        }

        int maxn = org.length + 1;

        int n = org.length;
        List[] graph = new ArrayList[maxn];
        for (int i = 0; i < maxn; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        int[] indegree = new int[maxn];
        Set<Integer> graphNodes = new HashSet<>();
        for (int[] edge : seqs) {
            for (int i = 0; i < edge.length; i++) {
                graphNodes.add(edge[i]);
                if (i >= 1) {
                    graph[edge[i - 1]].add(edge[i]);
                    indegree[edge[i]]++;
                }
            }
        }

        int[] result = new int[n];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int node : org) {
            if (indegree[node] == 0) {
                queue.offer(node);
            }
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            int poll = queue.poll();
            result[cnt++] = poll;
            for (Object neighbor : graph[poll]) {
                int v = (int) neighbor;
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        if (graphNodes.size() != cnt || cnt != n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (org[i] != result[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] org = {1};
        int[][] seqs = {};
        System.out.println(new Solution().sequenceReconstruction(org, seqs));
    }

}