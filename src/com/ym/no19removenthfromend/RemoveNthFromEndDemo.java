package com.ym.no19removenthfromend;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
//
//
//
// 进阶：你能尝试使用一趟扫描实现吗？
// Related Topics 链表 双指针 👍 1874 👎 0

/**
 * @author ym
 * @create 2022-03-17 15:16
 * @description
 */
public class RemoveNthFromEndDemo {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //1.使用快慢指针法，使快指针先走n个步骤
        // 这样的话，当慢指针走到待删除结点时，快指针已经走到结尾了
        //2.对于涉及到删除增加的链表类操作，最好用一个虚拟头节点
        // 并且这样就不用把头节点单独考虑了

        //虚拟头节点
        ListNode dummyNode = new ListNode(0, head);

        //快指针
        ListNode fastNode = dummyNode;
        //慢指针
        ListNode slowNode = dummyNode;

        //让快指针先走n步
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }

        //接下来让快指针和慢指针一起走,
        // 由于fastNode是从虚拟头节点开始，因此判断条件是fastNode.next!=null
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        //此时说明慢指针到了待删除结点的前一个，接下来开始删除
        slowNode.next = slowNode.next.next;
        //获取此时的虚拟头节点
        ListNode ans = dummyNode.next;
        //返回此时的头节点
        return ans;
    }
}
