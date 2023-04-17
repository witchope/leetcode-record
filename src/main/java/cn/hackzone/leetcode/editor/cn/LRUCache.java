package cn.hackzone.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存
 *
 * @author maxwell
 * @date 2023/03/14
 */
class LRUCache {
    private Map<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
        // 创建头尾节点，并将它们相互链接
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // 如果 key 不存在于 map 中，则返回 -1
        if (!map.containsKey(key)) {
            return -1;
        }
        // 如果 key 存在于 map 中，则将对应的节点移动到链表头部，并返回节点的值
        Node node = map.get(key);
        moveNodeToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 如果 key 已存在，则更新对应节点的值，并将节点移动到链表头部
            Node node = map.get(key);
            node.value = value;
            moveNodeToHead(node);
        } else {
            // 如果 key 不存在，则创建新的节点，并将节点添加到链表头部
            Node node = new Node(key, value);
            addNodeToHead(node);
            map.put(key, node);
            // 如果当前节点数超过缓存容量，则删除链表尾部的节点
            if (map.size() > capacity) {
                Node tailNode = removeTail();
                map.remove(tailNode.key);
            }
        }
    }

    private void moveNodeToHead(Node node) {
        // 将节点从当前位置删除
        removeNode(node);
        // 将节点添加到链表头部
        addNodeToHead(node);
    }

    private void removeNode(Node node) {
        // 将节点的前一个节点与后一个节点链接起来
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNodeToHead(Node node) {
        // 将节点插入到头节点之后
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private Node removeTail() {
        // 删除尾节点的前一个节点，即为要删除的尾节点
        Node tailNode = tail.prev;
        removeNode(tailNode);
        return tailNode;
    }
}