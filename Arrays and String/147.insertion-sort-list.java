/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
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
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);

        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while(cur!=null && cur.next!=null) {
            if(cur.val>cur.next.val) {
                //remove the next node
                temp = cur.next;
                prev = dummy;
                cur.next = cur.next.next;

                while(prev.next!=null && prev.next.val<=temp.val) {
                    prev = prev.next; //find the insert node
                }

                ListNode next = prev.next;
                prev.next = temp;
                temp.next = next;

            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
// @lc code=end

