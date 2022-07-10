package algorithm.p3_bfs.topological_sort.t605序列重构;

import java.util.*;

public class Solution2 {
    /**
     * @param org:  a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {

        Map<Integer, Set<Integer>> graph = buildGraph(seqs);
        List<Integer> topoOrder = getTopoOrder(graph);
        if (topoOrder == null || topoOrder.size() != org.length) {
            return false;
        }
        for (int i = 0; i < org.length; i++) {
            if (org[i] != topoOrder.get(i)) {
                return false;
            }
        }
        return true;

    }

    private List<Integer> getTopoOrder(Map<Integer, Set<Integer>> graph) {
        Map<Integer, Integer> indegree = getIndegree(graph);
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> topoOrder = new ArrayList<>();

        for (Integer node : indegree.keySet()) {
            if (indegree.get(node) == 0) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            // 队列中仅有一个元素，才能保证只有唯一一种拓扑排序
            if (queue.size() > 1) {
                return null;
            }
            int poll = queue.poll();
            topoOrder.add(poll);
            for (Integer node : graph.get(poll)) {
                indegree.put(node, indegree.get(node) - 1);
                if (indegree.get(node) == 0) {
                    queue.offer(node);
                }
            }
        }

        return topoOrder.size() == graph.size() ? topoOrder : null;
    }

    private Map<Integer, Integer> getIndegree(Map<Integer, Set<Integer>> graph) {
        Map<Integer, Integer> indegree = new HashMap<>();
        for (Integer node : graph.keySet()) {
            indegree.put(node, 0);
        }
        for (Integer node : graph.keySet()) {
            for (Integer neighbor : graph.get(node)) {
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }
        return indegree;
    }

    private Map<Integer, Set<Integer>> buildGraph(int[][] seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] seq : seqs) {
            for (int i = 0; i < seq.length; i++) {
                graph.put(seq[i], new HashSet<Integer>());
            }
        }
        for (int[] seq : seqs) {
            for (int i = 1; i < seq.length; i++) {
                graph.get(seq[i - 1]).add(seq[i]);
            }
        }
        return graph;
    }

}
