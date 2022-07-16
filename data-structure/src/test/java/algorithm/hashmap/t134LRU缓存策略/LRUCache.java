package algorithm.hashmap.t134LRU缓存策略;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author aabo
 * @createTime 2022/7/14 23:10
 */
public class LRUCache {

    static class ListNode {

        public int key;
        public int value;
        public ListNode next;

        public ListNode(int key, int value, ListNode next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

    public int capacity;

    public ListNode dummy;

    public ListNode tail;

    public Map<Integer, ListNode> keyToPre;

    /*
     * @param capacity: An integer
     */
    public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        this.dummy = new ListNode(0, 0, null);
        this.tail = this.dummy;
        this.keyToPre = new HashMap<>();
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {

        if (!keyToPre.containsKey(key)) {
            return -1;
        }
        kick(key);
        return tail.value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {

        if (keyToPre.containsKey(key)) {
            kick(key);
            tail.value = value;
            return;
        }

        pushBack(new ListNode(key, value, null));

        if (keyToPre.size() > capacity) {
            popFront();
        }
    }

    /**
     * 顺序调整
     *
     * @param key
     */
    private void kick(int key) {

        ListNode pre = keyToPre.get(key);
        ListNode moveNode = pre.next;
        if (moveNode == tail) {
            return;
        }

        // 移除节点
        pre.next = moveNode.next;
        keyToPre.put(pre.next.key, pre);
        moveNode.next = null;

        // 将移动节点放到链表尾部
        pushBack(moveNode);

    }

    private void pushBack(ListNode node) {
        // 当前tail成为node前一个节点
        keyToPre.put(node.key, tail);
        tail.next = node;
        tail = node;
    }

    private void popFront() {
        // 获得要删除的节点
        ListNode removeNode = dummy.next;
        keyToPre.remove(removeNode.key);
        dummy.next = removeNode.next;
        // 更新映射关系
        if (dummy.next != null) {
            keyToPre.put(dummy.next.key, dummy);
        }
    }

}