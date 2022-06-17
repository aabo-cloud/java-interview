package p3_bfs.topological_sort.t892外星人字典;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/892
 * 有一种新的使用拉丁字母的外来语言。但是，你不知道字母之间的顺序。
 * 你会从词典中收到一个非空的单词列表，其中的单词在这种新语言的规则下按字典顺序排序。
 * 请推导出这种语言的字母顺序。
 * <p>
 * 你可以假设所有的字母都是小写。
 * 如果字符串 a 是字符串 b 的前缀，且 b 出现在 a 之前，那么这个顺序是无效的。
 * 如果顺序是无效的，则返回空字符串。
 * 这里可能有多个有效的字母顺序，返回以正常字典顺序看来最小的。
 * 一个字符串中的字母默认是同一等级的，且按照人类字典序排序。
 *
 * @author aabo
 * @createTime 2022/6/16 17:25
 */
public class Main {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = buildGraph(words);
        if (graph == null) {
            return "";
        }
        return getTopoOrder(graph);
    }

    private String getTopoOrder(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = getIndegree(graph);
        // 构建堆，每次取字典序最小的
        Queue<Character> queue = new PriorityQueue<>();
        StringBuilder topoOrder = new StringBuilder();
        for (Character node : indegree.keySet()) {
            if (indegree.get(node) == 0) {
                queue.offer(node);
            }
        }
        while (!queue.isEmpty()) {
            char poll = queue.poll();
            topoOrder.append(poll);
            for (Character neighbor : graph.get(poll)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return topoOrder.length() == graph.size() ? topoOrder.toString() : "";
    }

    private Map<Character, Integer> getIndegree(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = new HashMap<>();
        for (Character node : graph.keySet()) {
            indegree.put(node, 0);
        }
        for (Character node : graph.keySet()) {
            for (Character neighbor : graph.get(node)) {
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }
        return indegree;
    }

    private Map<Character, Set<Character>> buildGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                graph.put(word.charAt(i), new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            int index = 0;
            String s1 = words[i], s2 = words[i + 1];
            while (index < s1.length() && index < s2.length()) {
                if (s1.charAt(index) != s2.charAt(index)) {
                    graph.get(s1.charAt(index)).add(s2.charAt(index));
                    break;
                }
                index++;
            }
            if (index == Math.min(s1.length(), s2.length()) && s1.length() > s2.length()) {
                return null;
            }
        }
        return graph;
    }


}