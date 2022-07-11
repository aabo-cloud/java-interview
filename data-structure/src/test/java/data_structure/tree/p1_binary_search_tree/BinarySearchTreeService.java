package data_structure.tree.p1_binary_search_tree;

/**
 * Created by IntelliJ IDEA.
 *
 * @author aabo
 * @createTime 2022/7/10 20:31
 */
public interface BinarySearchTreeService {

    /**
     * 遍历树 - 中序
     *
     * @param root
     */
    void traversalTree(TreeNode root);

    /**
     * 插入结点
     *
     * @param root
     * @param node
     * @return
     */
    TreeNode insertNode(TreeNode root, TreeNode node);


    /**
     * 删除节点
     *
     * @param root
     * @param value
     * @return
     */
    TreeNode deleteNode(TreeNode root, int value);

    /**
     * 查找结点
     *
     * @param root
     * @param value
     * @return
     */
    TreeNode selectNode(TreeNode root, int value);


    /**
     * 查找父结点
     *
     * @param parent
     * @param node
     * @param value
     * @return
     */
    TreeNode selectParent(TreeNode parent, TreeNode node, int value);

}
