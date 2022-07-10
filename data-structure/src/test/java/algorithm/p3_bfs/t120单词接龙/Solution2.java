package algorithm.p3_bfs.t120单词接龙;

// 双向宽度优先搜索

import java.util.*;

public class Solution2 {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {

        if (start.equals(end)) {
            return 1;
        }
        if (dict == null || dict.size() == 0) {
            return 0;
        }

        dict.add(start);
        dict.add(end);

        return bfs(start, end, buildGraph(dict));
    }

    private int bfs(String start, String end, Map<String, Set<String>> graph) {

        Queue<String> forwardQueue = new LinkedList<>();
        Queue<String> backwardQueue = new LinkedList<>();
        Set<String> forwardVisited = new HashSet<>();
        Set<String> backwardVisited = new HashSet<>();
        forwardQueue.offer(start);
        backwardQueue.offer(end);
        forwardVisited.add(start);
        backwardVisited.add(end);

        // 这里初始化为1，每次增加1是因为变换了一次
        int result = 1;
        while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()) {

            result++;
            if (extendQueue(graph, forwardQueue, forwardVisited, backwardVisited)) {
                return result;
            }
            result++;
            if (extendQueue(graph, backwardQueue, backwardVisited, forwardVisited)) {
                return result;
            }

        }

        return 0;

    }

    private boolean extendQueue(Map<String, Set<String>> graph, Queue<String> queue, Set<String> visited, Set<String> oppositeVisited) {

        int levelSize = queue.size();
        for (int i = 0; i < levelSize; i++) {

            String poll = queue.poll();
            for (String neighbor : graph.get(poll)) {
                if (visited.contains(neighbor)) {
                    continue;
                }
                if (oppositeVisited.contains(neighbor)) {
                    return true;
                }
                queue.offer(neighbor);
                visited.add(neighbor);
            }

        }

        return false;
    }

    private Map<String, Set<String>> buildGraph(Set<String> dict) {

        Map<String, Set<String>> graph = new HashMap<>();
        for (String node : dict) {
            graph.put(node, getNeighbors(node, dict));
        }

        return graph;
    }

    private Set<String> getNeighbors(String node, Set<String> dict) {

        Set<String> neighbors = new HashSet<>();

        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < node.length(); i++) {
                String neighbor = replaceWord(node, c, i);
                if (neighbor.equals(node) || !dict.contains(neighbor)) {
                    continue;
                }
                neighbors.add(neighbor);
            }
        }

        return neighbors;
    }

    private String replaceWord(String node, char word, int index) {
        char[] charArray = node.toCharArray();
        charArray[index] = word;
        return new String(charArray);
    }


}
