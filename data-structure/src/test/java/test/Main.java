package test;

/**
 * Created by IntelliJ IDEA.
 *
 * @author aabo
 * @createTime 2022/7/19 18:36
 */

class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Main {

    public static void main(String[] args) {



    }

    private static ListNode sort(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow.next;
        slow.next = null;

        ListNode left = sort(head);
        ListNode right = sort(temp);

        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                dummy.next = left;
                left = left.next;
            } else {
                node.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }

        dummy.next = left != null ? left : right;

        return node.next;
    }



}
