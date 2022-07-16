package algorithm.p4_divide_conquer.t95验证二叉查找树;

import algorithm.header.TreeNode;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/95/
 * 给定一个二叉树，判断它是否是合法的二叉查找树(BST)
 * <p>
 * 一棵BST定义为：
 * <p>
 * 节点的左子树中的值要严格小于该节点的值。
 * 节点的右子树中的值要严格大于该节点的值。
 * 左右子树也必须是二叉查找树。
 * 一个节点的树也是二叉查找树。
 *
 * @author aabo
 * @createTime 2022/7/14 16:48
 */
public class Main {

    static class ResultType {
        public boolean isValid;
        public long minValue;
        public long maxValue;

        public ResultType(boolean isValid, long minValue, long maxValue) {
            this.isValid = isValid;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }

    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root).isValid;
    }

    private ResultType helper(TreeNode root) {

        if (root == null) {
            return new ResultType(true, Long.MAX_VALUE, Long.MIN_VALUE);
        }

        ResultType leftResult = helper(root.left);
        ResultType rightResult = helper(root.right);

        boolean isValid = true;

        if (!leftResult.isValid || !rightResult.isValid
                || leftResult.maxValue >= root.val
                || root.val >= rightResult.minValue) {
            isValid = false;
        }

        return new ResultType(isValid, root.left == null ? root.val : leftResult.minValue,
                root.right == null ? root.val : rightResult.maxValue);

    }

}