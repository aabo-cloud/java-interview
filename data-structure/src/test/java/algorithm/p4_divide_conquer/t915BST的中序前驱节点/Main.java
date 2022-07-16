package algorithm.p4_divide_conquer.t915BST的中序前驱节点;

import algorithm.header.TreeNode;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/915
 * 给出一棵二叉搜索树以及其中的一个节点，找到这个节点在这棵树中的中序前驱节点。
 *
 * @author aabo
 * @createTime 2022/7/14 17:52
 */
public class Main {

    /**
     * @param root: the given BST
     * @param p:    the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {

        if (root == null || p == null || (root.left == null && root.right == null)) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode[] record = new TreeNode[2];
        record[0] = null;
        int index = 1;
        while (root != null || !stack.isEmpty()) {

            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root == p) {
                    return record[index ^ 1];
                }
                record[index] = root;
                index ^= 1;
                root = root.right;
            }

        }

        return null;
    }

}
