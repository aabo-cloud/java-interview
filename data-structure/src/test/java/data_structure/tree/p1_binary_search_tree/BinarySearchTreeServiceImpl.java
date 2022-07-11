package data_structure.tree.p1_binary_search_tree;

/**
 * Created by IntelliJ IDEA.
 *
 * @author aabo
 * @createTime 2022/7/10 20:52
 */
public class BinarySearchTreeServiceImpl implements BinarySearchTreeService {


    @Override
    public void traversalTree(TreeNode root) {

        if (root == null) {
            return;
        }
        traversalTree(root.left);
        System.out.print(root.value + " ");
        traversalTree(root.right);

    }

    @Override
    public TreeNode insertNode(TreeNode root, TreeNode node) {

        if (root == null) {
            return node;
        }
        if (node.value < root.value) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }
        return root;

    }

    @Override
    public TreeNode deleteNode(TreeNode root, int value) {

        // 临时结点
        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;
        // 查找父结点
        TreeNode parent = selectParent(dummy, root, value);
        TreeNode delNode = null;
        boolean isLeft = true;
        if (parent.left != null && parent.left.value == value) {
            delNode = parent.left;
        } else if (parent.right != null && parent.right.value == value) {
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

    @Override
    public TreeNode selectNode(TreeNode root, int value) {

        if (root == null || root.value == value) {
            return root;
        }
        if (value < root.value) {
            return selectNode(root.left, value);
        }
        return selectNode(root.right, value);

    }

    @Override
    public TreeNode selectParent(TreeNode parent, TreeNode node, int value) {

        if (node == null || node.value == value) {
            return parent;
        }

        if (value < node.value) {
            return selectParent(node, node.left, value);
        }
        return selectParent(node, node.right, value);

    }

    /**
     * 模拟二叉搜索树四种删除节点的请求
     * 代码上有很多可以优化的地方
     *
     * @param parent
     * @param node
     * @param isLeft
     */
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
        while (next.left != null) {
            nextFather = next;
            next = next.left;
        }
        // 4.1 待删除节点右子树没有左子树
        if (nextFather.right == next) {
            if (isLeft) {
                parent.left = next;
            } else {
                parent.right = next;
            }
            next.left = nextFather.left;
            return;
        }
        // 4.2 待删除节点右子树含左子树
        if (nextFather.left == next) {
            // 后继含右单支树
            if (next.right != null) {
                nextFather.left = next.right;
            } else {
                nextFather.left = null;
            }
            // 用后继替换要删除的节点
            if (isLeft) {
                parent.left = next;
            } else {
                parent.right = next;
            }
            next.left = node.left;
            next.right = node.right;
        }

    }

}
