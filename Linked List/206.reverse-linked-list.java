/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null,temp=null;
        ListNode cur = head;
        while(cur!=null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;

        }
        return prev;
    }
}
// @lc code=end

