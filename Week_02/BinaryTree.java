import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历和前序遍历
 *
 * @author Q
 */
public class BinaryTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);

        System.out.println(inOrderTraversal(root));
        System.out.println(preOrderTraversal(root));
    }

    static List<Integer> list = new ArrayList<>();

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> inOrderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        } else if (root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }

        if (root.left != null) {
            inOrderTraversal(root.left);
        }

        list.add(root.val);

        if (root.right != null) {
            inOrderTraversal(root.right);
        }

        return list;
    }

    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> preOrderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        } else if (root.right == null && root.left == null) {
            list.add(root.val);
            return list;
        }

        list.add(root.val);

        if (root.left != null) {
            preOrderTraversal(root.left);
        }

        if (root.right != null) {
            preOrderTraversal(root.right);
        }

        return list;
    }
}
