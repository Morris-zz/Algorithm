package base.find;

import java.util.HashMap;

/**
 * @Author: morris
 * @Date: 2020/8/17 9:22
 * @reviewer
 */
public class LRUCache2 {
    class LruNode {
        int key;
        int value;
        LruNode prev;
        LruNode next;

        public LruNode() {
        }

        public LruNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, LruNode> map = new HashMap<Integer, LruNode>();
    private int size;
    private int capacity;
    private LruNode head;
    private LruNode tail;

    public LRUCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new LruNode();
        tail = new LruNode();
        head.next = tail;
        tail.prev = head;
    }
    private int get(int key){
        LruNode lruNode = map.get(key);
        if (lruNode == null){
            return -1;
        }
        moveToHead(lruNode);
        return lruNode.value;
    }

    private void put(int key, int value) {
        LruNode lruNode = map.get(key);
        if (lruNode == null) {
            LruNode node = new LruNode(key, value);
            addToHead(node);
            map.put(key, node);
            size++;
            if (size > capacity) {
                removeTail();
                size--;
            }
        } else {
            moveToHead(lruNode);
        }
    }

    /**
     * 将存在节点移动到head
     * @param node
     */
    private void moveToHead(LruNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 删除节点
     * @param node
     */
    private void removeNode(LruNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 将node放在虚拟头结点后
     *
     * @param node
     */
    private void addToHead(LruNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 将node放在虚拟尾节点后
     *
     * @param node
     */
    private void addToTail(LruNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    /**
     * 移除尾节点
     */
    private void removeTail() {
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }
}














