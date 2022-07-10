package data_structure.tree.p1_binary_search_tree;

/**
 * Created by IntelliJ IDEA.
 *
 * @author aabo
 * @createTime 2022/7/10 20:28
 */
public class TreeNode {

    public static int count = 0;

    public int key;

    public int value;

    public TreeNode left;

    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.key = count++;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.key = count++;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int key, int value, TreeNode left, TreeNode right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "key=" + key +
                ", value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

}
