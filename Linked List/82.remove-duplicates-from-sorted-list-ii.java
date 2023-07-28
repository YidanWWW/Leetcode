/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode cur = prev.next;

        while(cur!=null) {
            if(cur.next!=null && cur.val == cur.next.val) {
                int dup = cur.val;
                while(cur!=null && cur.val==dup) {
                    cur = cur.next;
                }
                prev.next = cur;
            }else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
// @lc code=end

