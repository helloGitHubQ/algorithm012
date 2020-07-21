import entity.Node;

import java.util.*;

/**
 * 589.N 叉树的前序遍历/层序遍历！！！ 429
 *
 * @author Q
 */
public class NaryTree {
    public static void main(String[] args) {
        Node root = new Node(3);
        List<Node> childrenList = new ArrayList<>();
        childrenList.add(new Node(4));
        childrenList.add(new Node(5));
        childrenList.add(new Node(6));
        childrenList.add(new Node(1));
        root.children = childrenList;

        System.out.println(preOrder(root));
        System.out.println(levelOrderPlus(root));
    }

    static List<Integer> list = new ArrayList<>();

    /**
     * 固定模板解题法
     *
     * @param root
     * @return
     */
    public static List<Integer> preOrder(Node root) {
        if (root == null) {
            return null;
        } else if (root.children == null) {
            list.add(root.val);
            return list;
        }

        list.add(root.val);

        if (root.children != null) {
            for (Node node :
                    root.children) {
                preOrder(node);
            }
        }

        return list;
    }


    /**
     * 广度优先算法
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderPlus(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Node> previousLayer = Arrays.asList(root);

        while (!previousLayer.isEmpty()) {
            List<Node> currentLayer = new ArrayList<>();
            List<Integer> previousVals = new ArrayList<>();
            for (Node node : previousLayer) {
                previousVals.add(node.val);
                currentLayer.addAll(node.children);
            }
            result.add(previousVals);
            previousLayer = currentLayer;
        }

        return result;
    }
}
