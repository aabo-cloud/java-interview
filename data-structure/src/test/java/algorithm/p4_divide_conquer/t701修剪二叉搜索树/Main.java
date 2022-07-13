package algorithm.p4_divide_conquer.t701修剪二叉搜索树;

import algorithm.header.TreeNode;

/**
 * Created by IntelliJ IDEA.
 * https://www.lintcode.com/problem/701/description
 * 给定一个有根的二叉搜索树和两个数字min和max，修整这个树使得所有的数字在这个新的树种都是在min和max之间（包括min和max）。
 * 然后这个所得的树仍然是合法的二叉搜索树。
 *
 * @author aabo
 * @createTime 2022/7/12 22:30
 */
public class Main {


    /**
     * @param root:    given BST
     * @param minimum: the lower limit
     * @param maximum: the upper limit
     * @return: the root of the new tree
     */
    public TreeNode trimBST(TreeNode root, int minimum, int maximum) {

        if (root == null) {
            return null;
        }

        // 需要修剪的结点直接返回子结点
        if (root.val < minimum) {
            // 太小的结点把自己和左子树丢掉
            return trimBST(root.right, minimum, maximum);
        } else if (root.val > maximum) {
            // 太大的结点把自己和右子树丢掉
            return trimBST(root.left, minimum, maximum);
        } else {
            // 不需要修剪的结点重新获取左右子树
            root.left = trimBST(root.left, minimum, maximum);
            root.right = trimBST(root.right, minimum, maximum);
        }

        // 把当前节点返回给上一层递归作为 左/右子树
        return root;
    }


}
