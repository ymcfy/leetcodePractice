package com.ym.no876middlenode;

/**
 * 大神成果，可供参考
 * 作者：liweiwei1419
 * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list/solution/kuai-man-zhi-zhen-zhu-yao-zai-yu-diao-shi-by-liwei/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int x) {
        val = x;
    }

    public ListNode1(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = nums[0];
        ListNode1 curr = this;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode1(nums[i]);
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode1 cur = this;
        while (cur != null) {
            s.append(cur.val);
            s.append(" -> ");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}

public class Solution {

    public ListNode1 middleNode(ListNode1 head) {
        if (head == null) {
            return null;
        }
        ListNode1 slow = head;
        ListNode1 fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        // int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode1 head = new ListNode1(arr);
        Solution solution = new Solution();
        ListNode1 res = solution.middleNode(head);
        System.out.println(res);
    }
}

