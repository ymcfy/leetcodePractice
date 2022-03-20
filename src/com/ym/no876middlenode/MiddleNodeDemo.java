package com.ym.no876middlenode;

/**
 * @author ym
 * @create 2022-03-17 11:04
 * @description
 */
public class MiddleNodeDemo {
    public ListNode middleNode(ListNode head) {
        //注意代码的健壮性
        if (head == null) {
            return null;
        }
        //使用快慢指针法
        //快指针一次两步，慢指针一次一步，这样的话等快指针走到最后，慢指针正好走到一半
        ListNode slow = head;
        ListNode fast = head;
        //只要快指针没走到最后，就可以继续
        // 此处有一个地方之后做链表题目的时候可以注意，那就是题目是[1,2,3,4,5,6]
        //其实链表是1->2->3->4->5->6->null
        //也就是说最后这个6之后还有个null，可以取到
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
