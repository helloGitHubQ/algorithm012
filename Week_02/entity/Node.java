package entity;

import java.util.List;

/**
 * @author Q
 */
public class Node {

    public int val;

    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
