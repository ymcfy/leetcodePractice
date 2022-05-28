package com.ym.no21mergetwolists;

/**
 * @author ym
 * @date 2022/05/24 15:19:40
 * @description
 **/
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //创建一个头结点，用一个变量指针prev表示，对两个链表的头结点进行比较
        //较小的那个结点作为头结点的next，并将此结点赋值给prev
        //并且将此结点的下一个结点作为所属链表的头结点
        //此时继续比较两个链表的头结点
        //直到某一个链表比较完成，退出循环
        //当循环结束，两个链表最多还有一个是非空的，即剩余结点未参与比较的
        //由于两个链表均是升序链表，那么可以直接将非空链表加在最后即可

        //创建一个头结点
        ListNode prevNode = new ListNode(-1);

        //用一个变量指针prev表示将要比较的结点的上一个，或者说已经比较好的链表的最后一个
        ListNode prev = prevNode;

        //循环对两个链表的头结点进行比较
        //直到某一个链表比较完成，退出循环
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                //较小的那个结点作为头结点的next
                prev.next = list1;
                //将此结点的下一个结点作为所属链表的头结点
                list1 = list1.next;
            } else {
                //较小的那个结点作为头结点的next
                prev.next = list2;
                //将此结点的下一个结点作为所属链表的头结点
                list2 = list2.next;
            }
            //将比较得到的最小结点赋值给prev
            prev = prev.next;
        }
        //当循环结束，两个链表最多还有一个是非空的，即剩余结点未参与比较的
        //由于两个链表均是升序链表，那么可以直接将非空链表加在最后即可
        if (list1 == null) {
            prev.next = list2;
        } else {
            prev.next = list1;
        }
        //返回头结点的下一个结点即为新的升序链表的首链表
        return prevNode.next;
    }
}
