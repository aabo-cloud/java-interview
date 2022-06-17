package p3_bfs.topological_sort.t127拓扑排序;

import header.DirectedGraphNode;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/127
 * 给定一个有向图，图节点的拓扑排序定义如下:
 * 对于图中的每一条有向边 A -> B , 在拓扑排序中A一定在B之前.
 * 拓扑排序中的第一个节点可以是图中的任何一个没有其他节点指向它的节点.
 * 针对给定的有向图找到任意一种拓扑排序的顺序.
 * <p>
 * 你可以假设图中至少存在一种拓扑排序
 * 图结点的个数 <= 5000
 *
 * @author aabo
 * @createTime 2022/6/16 17:14
 */
public class Main {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {

        if (graph == null || graph.size() == 0) {
            return graph;
        }

        Map<DirectedGraphNode, Integer> indegree = getIndegree(graph);

        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        Queue<DirectedGraphNode> queue = new ArrayDeque<>();
        for (DirectedGraphNode node : graph) {
            if (!indegree.containsKey(node)) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            DirectedGraphNode poll = queue.poll();
            result.add(poll);
            for (DirectedGraphNode neighbor : poll.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return result;

    }

    private Map<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph) {
        HashMap<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegree.put(neighbor, indegree.getOrDefault(neighbor, 0) + 1);
            }
        }
        return indegree;
    }

}