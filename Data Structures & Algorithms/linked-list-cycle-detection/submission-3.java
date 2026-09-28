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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head; 
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;      // Take one step.
            fast = fast.next.next; // Take two steps.

            if (slow == fast) {    // Same node means they met in a cycle.
                return true;
            }
        }

        return false; // Fast reached the end, so there is no cycle.
    }
}
