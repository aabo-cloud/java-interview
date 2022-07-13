package algorithm.p4_divide_conquer.t87删除二叉查找树的节点;

import algorithm.header.TreeNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author aabo
 * @createTime 2022/7/12 23:35
 */
public class Main {

    /**
     * @param root:  The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        return deleteNode(root, value);
    }

    public TreeNode deleteNode(TreeNode root, int value) {

        // 临时结点
        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;
        // 查找父结点
        TreeNode parent = selectParent(dummy, root, value);
        TreeNode delNode = null;
        boolean isLeft = true;
        if (parent.left != null && parent.left.val == value) {
            delNode = parent.left;
        } else if (parent.right != null && parent.right.val == value) {
            delNode = parent.right;
            isLeft = false;
        } else {
            // 没有找到要删除的节点
            return dummy.left;
        }
        // 删除找到的结点
        deleteTreeNode(parent, delNode, isLeft);

        return dummy.left;
    }

    public TreeNode selectParent(TreeNode parent, TreeNode node, int value) {

        if (node == null || node.val == value) {
            return parent;
        }

        if (value < node.val) {
            return selectParent(node, node.left, value);
        }

        return selectParent(node, node.right, value);
    }

    private void deleteTreeNode(TreeNode parent, TreeNode node, boolean isLeft) {

        // 1. 待删除节点是叶子结点
        if (node.left == null && node.right == null) {
            if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return;
        }
        // 2. 待删除节点为单支节点 - 左子树为空
        if (node.left == null) {
            if (isLeft) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
            return;
        }
        // 3. 待删除节点为单支节点 - 右子树为空
        if (node.right == null) {
            if (isLeft) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
            return;
        }
        // 4. 待删除节点有左右两颗子树
        // 用前驱/后继来替换待删除节点，再删除交换后的前驱/后继的位置，删除的位置一定是叶子结点或者单支树
        TreeNode next = node.right;
        TreeNode nextFather = node;
        // 寻找后继
        while (next.left != null) {
            nextFather = next;
            next = next.left;
        }
        // 4.1 待删除节点右孩子没有左子树
        if (nextFather.right == next) {
            if (isLeft) {
                parent.left = next;
            } else {
                parent.right = next;
            }
            // 后继的左子树继承待删除节点的左子树 右子树不变
            next.left = node.left;
            return;
        }
        // 4.2 待删除节点右子树含左子树
        if (nextFather.left == next) {
            // 后继的右子树连接
            nextFather.left = next.right;
            // 用后继替换要删除的节点
            if (isLeft) {
                parent.left = next;
            } else {
                parent.right = next;
            }
            // 后继替换带删除节点
            next.left = node.left;
            next.right = node.right;
        }

    }

}
