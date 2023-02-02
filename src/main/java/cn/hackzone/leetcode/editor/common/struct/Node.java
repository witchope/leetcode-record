package cn.hackzone.leetcode.editor.common.struct;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node() {
        super();
    }

    public Node(int _val) {
        super();
        this.val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        this.val = _val;
        this.left = _left;
        this.right = _right;
        this.next = _next;
    }
}
