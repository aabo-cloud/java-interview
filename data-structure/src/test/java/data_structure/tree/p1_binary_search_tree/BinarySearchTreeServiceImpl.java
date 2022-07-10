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


}
