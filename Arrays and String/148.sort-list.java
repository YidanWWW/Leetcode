/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
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
    public ListNode sortList(ListNode head) {
        //recursion
        if(head==null || head.next==null) return head;
        ListNode mid = findMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
        
    }

    public ListNode findMid(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;

        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(list1!=null && list2!=null) {
            if(list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            }else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }
        if(list1!=null) cur.next = list1;
        if(list2!=null) cur.next = list2;
        return dummy.next;
    }
}
// @lc code=end

