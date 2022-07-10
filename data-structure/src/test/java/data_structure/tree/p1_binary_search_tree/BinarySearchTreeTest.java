package data_structure.tree.p1_binary_search_tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 *
 * @author aabo
 * @createTime 2022/7/10 20:56
 */
public class BinarySearchTreeTest {

    public BinarySearchTreeService binarySearchTreeService = new BinarySearchTreeServiceImpl();

    public static TreeNode root = null;

    @Before
    public void initTree() {

        root = binarySearchTreeService.insertNode(null, new TreeNode(100));
        binarySearchTreeService.insertNode(root, new TreeNode(50));
        binarySearchTreeService.insertNode(root, new TreeNode(200));
        binarySearchTreeService.insertNode(root, new TreeNode(60));
        binarySearchTreeService.insertNode(root, new TreeNode(300));

    }

    @Test
    public void traversalTree() {
        binarySearchTreeService.traversalTree(root);
    }

    @Test
    public void selectNode() {
        Assert.assertEquals(200, binarySearchTreeService.selectNode(root, 200).value);
        Assert.assertEquals(300, binarySearchTreeService.selectNode(root, 300).value);
        Assert.assertEquals(100, binarySearchTreeService.selectNode(root, 100).value);
    }

    @Test
    public void selectParent() {

        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;
        System.out.println(binarySearchTreeService.selectParent(dummy, root, 60));
        System.out.println(binarySearchTreeService.selectParent(dummy, root, 300));

    }

}
