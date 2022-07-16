package algorithm.p4_divide_conquer.t448二叉查找树的中序后继;

import algorithm.header.TreeNode;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/448/description
 * 给定一个二叉查找树(什么是二叉查找树)，以及一个节点，求该节点在中序遍历的后继，如果没有则返回null
 *
 * @author aabo
 * @createTime 2022/7/14 16:51
 */
public class Main {

    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if (root == null || p == null || (root.left == null && root.right == null)) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();

        // 记录前驱后继
        TreeNode[] record = new TreeNode[2];
        record[0] = null;
        int index = 1;
        while (root != null || !stack.isEmpty()) {

            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (record[index ^ 1] == p) {
                    return root;
                }
                record[index] = root;
                index ^= 1;
                root = root.right;
            }

        }

        return null;
    }


}
