package p3_bfs.t137克隆图;

import header.UndirectedGraphNode;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/137
 * 克隆一张无向图. 无向图的每个节点包含一个 label 和一个列表 neighbors. 保证每个节点的 label 互不相同.
 * 你的程序需要返回一个经过深度拷贝的新图. 新图和原图具有同样的结构, 并且对新图的任何改动不会对原图造成任何影响.
 *
 * @author aabo
 * @createTime 2022/6/16 15:53
 */
public class Main {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (node == null) {
            return node;
        }

        // 找节点
        List<UndirectedGraphNode> nodes = findNodes(node);

        // 复制节点
        Map<UndirectedGraphNode, UndirectedGraphNode> nodeMap = copyNodes(nodes);

        // 复制边
        copyEdges(nodes, nodeMap);

        return nodeMap.get(node);

    }

    private List<UndirectedGraphNode> findNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        queue.offer(node);
        visited.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode poll = queue.poll();
            for (UndirectedGraphNode neighbor : poll.neighbors) {
                if (visited.contains(neighbor)) {
                    continue;
                }
                visited.add(neighbor);
                queue.offer(neighbor);
            }
        }
        return new ArrayList<>(visited);
    }

    /**
     * 灵活使用 HashMap 存放一个 pair
     *
     * @param nodes
     * @return
     */
    private Map<UndirectedGraphNode, UndirectedGraphNode> copyNodes(List<UndirectedGraphNode> nodes) {
        Map<UndirectedGraphNode, UndirectedGraphNode> nodeHashMap = new HashMap<>();
        for (UndirectedGraphNode preNode : nodes) {
            nodeHashMap.put(preNode, new UndirectedGraphNode(preNode.label));
        }
        return nodeHashMap;
    }

    private void copyEdges(List<UndirectedGraphNode> nodes, Map<UndirectedGraphNode, UndirectedGraphNode> nodeHashMap) {
        for (UndirectedGraphNode node : nodes) {
            for (UndirectedGraphNode neighbor : node.neighbors) {
                nodeHashMap.get(node).neighbors.add(nodeHashMap.get(neighbor));
            }
        }
    }

}