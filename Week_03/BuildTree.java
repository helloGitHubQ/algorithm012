import entity.TreeNode2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 105.从前序与中序遍历序列构建二叉树
 *
 * @author Q
 */
public class BuildTree {
    private static Map<Integer, Integer> indexMap;

    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        TreeNode2 treeNode2 = buildTree(preOrder, inOrder);
        System.out.println(treeNode2);
    }


    public static TreeNode2 myBuildTree2(int[] preorder, int[] inorder, int preorderLeft, int preorder_right, int inorder_left, int inorder_right) {
        if (preorderLeft > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorderLeft;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode2 root = new TreeNode2(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree2(preorder, inorder, preorderLeft + 1, preorderLeft + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree2(preorder, inorder, preorderLeft + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    /**
     * 递归
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode2 buildTree2(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree2(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    /**
     * 迭代
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode2 buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        Stack<TreeNode2> roots = new Stack<TreeNode2>();
        int pre = 0;
        int in = 0;
        //先序遍历第一个值作为根节点
        TreeNode2 curRoot = new TreeNode2(preorder[pre]);
        TreeNode2 root = curRoot;
        roots.push(curRoot);
        pre++;
        //遍历前序遍历的数组
        while (pre < preorder.length) {
            //出现了当前节点的值和中序遍历数组的值相等，寻找是谁的右子树
            if (curRoot.val == inorder[in]) {
                //每次进行出栈，实现倒着遍历
                while (!roots.isEmpty() && roots.peek().val == inorder[in]) {
                    curRoot = roots.peek();
                    roots.pop();
                    in++;
                }
                //设为当前的右孩子
                curRoot.right = new TreeNode2(preorder[pre]);
                //更新 curRoot
                curRoot = curRoot.right;
                roots.push(curRoot);
                pre++;
            } else {
                //否则的话就一直作为左子树
                curRoot.left = new TreeNode2(preorder[pre]);
                curRoot = curRoot.left;
                roots.push(curRoot);
                pre++;
            }
        }
        return root;
    }
}
