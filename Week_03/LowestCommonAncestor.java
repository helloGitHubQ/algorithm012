import entity.TreeNode2;

/**
 * 236.二叉树的最近公共祖先
 *
 * @author Q
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode2 treeNode = new TreeNode2(3);
        TreeNode2 left = new TreeNode2(5);
        TreeNode2 right = new TreeNode2(1);
        treeNode.left = left;
        treeNode.right = right;

        TreeNode2 rightR = new TreeNode2(2);
        left.left = new TreeNode2(6);
        left.right = rightR;

        rightR.left = new TreeNode2(7);
        rightR.right = new TreeNode2(4);

        TreeNode2 rightL = new TreeNode2(0);
        TreeNode2 rightR1 = new TreeNode2(8);
        right.left = rightL;
        right.right = rightR1;

        TreeNode2 p = new TreeNode2(5);
        TreeNode2 q = new TreeNode2(7);

        TreeNode2 result = lowestCommonAncestorS(treeNode, p, q);
        System.out.println(result);
    }

    /**
     * 递归 ？
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode2 lowestCommonAncestor(TreeNode2 root, TreeNode2 p, TreeNode2 q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode2 left = lowestCommonAncestor(root.left, p, q);
        TreeNode2 right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        }

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }

    public static TreeNode2 lowestCommonAncestorS(TreeNode2 root, TreeNode2 p, TreeNode2 q) {
        if(root == null || root == p || root == q) return root;
        TreeNode2 left = lowestCommonAncestor(root.left, p, q);
        TreeNode2 right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) return null; // 1.
        if(left == null) return right; // 3.
        if(right == null) return left; // 4.
        return root; // 2. if(left != null and right != null)
    }
}
