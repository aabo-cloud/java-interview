package algorithm.header;

/**
 * Created by IntelliJ IDEA.
 *
 * @author aabo
 * @createTime 2022/6/16 17:11
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for Directed graph.
 **/
public class DirectedGraphNode {
    public int label;
    public List<DirectedGraphNode> neighbors;

    public DirectedGraphNode(int label) {
        this.label = label;
        neighbors = new ArrayList<DirectedGraphNode>();
    }

    @Override
    public String toString() {
        return "DirectedGraphNode{" +
                "label=" + label +
                '}';
    }
}