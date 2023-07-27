/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        int len1 = 0;
        ListNode p1 = headA;
        while(p1!=null) {
            p1 = p1.next;
            len1++;
        }
        int len2 = 0;
        ListNode p2 = headB;
        while(p2!=null) {
            p2 = p2.next;
            len2++;
        }
        int len = Math.abs(len1-len2);
        while(len>=0) {
            if(len1>0) {
                headA = headA.next;
            }else {
                headB = headB.next;
            }
            len--;
        }
        while(headA!=null || headB!=null) {
            if(headA==headB){
                return new ListNode(headA.val);
            }else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
// @lc code=end

