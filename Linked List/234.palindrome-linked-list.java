/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;

        //fast snd slow pointers to find middle node
        //reverse second part
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;

        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //reverse second part;
        ListNode prev = null, temp = null, cur = slow.next;
        while(cur!=null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        slow.next = null;
        while(head!=null && prev!=null) {
            if(head.val!=prev.val) return false;
            head = head.next;
            prev = prev.next;
        }

        return true;
    }
}
// @lc code=end

