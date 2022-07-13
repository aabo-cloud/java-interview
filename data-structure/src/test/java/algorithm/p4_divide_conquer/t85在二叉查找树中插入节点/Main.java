package algorithm.p4_divide_conquer.t85在二叉查找树中插入节点;

import algorithm.header.TreeNode;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/85
 * 给定一棵二叉查找树和一个新的树节点，将节点插入到树中。
 * 你需要保证该树仍然是一棵二叉查找树。
 *
 * @author aabo
 * @createTime 2022/7/12 23:32
 */
public class Main {
    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {

        // 找到插入位置 插入位置永远都是叶子结点
        if (root == null) {
            return node;
        }

        if (node.val < root.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }

        // 在节点重新获取左右子树之后
        // 把当前节点返回给上一层递归作为 左/右子树
        return root;
    }

}