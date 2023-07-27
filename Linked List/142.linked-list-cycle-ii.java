/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //1.check if there is a cycle
        //first encounter:
        //len = a + b
        //fast = 2slow = slow+nb : fast = fast.next.next, slow = slow.next
        //fast = 2nb, slow = nb
        
        //second incounter
        //fast = 0, slow = nb, fast=fast.next, slow=slow.next;
        //fast = a, slow=a+nb, which means they meet
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) break; //have found intersection
        }
        if(fast == null || fast.next==null) return null;
        while(head!=fast) {
            head = head.next;
            fast = fast.next;
        }
        return head;
    }
}
// @lc code=end

