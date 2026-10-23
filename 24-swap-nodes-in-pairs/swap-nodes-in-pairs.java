/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // Create a dummy node to act as the preceding node for the original head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // 'prev' pointer always points to the node *before* the current pair
        ListNode prev = dummy;
        
        // Loop as long as there are at least two nodes remaining to swap
        while (prev.next != null && prev.next.next != null) {
            
            // 1. Identify the nodes in the pair and the start of the next pair
            ListNode nodeA = prev.next;
            ListNode nodeB = prev.next.next;
            ListNode nodeC = nodeB.next; // Node C is the start of the next pair (or null)

            // 2. Perform the swap by updating pointers:
            
            // P -> B: Link the preceding node to the second node
            prev.next = nodeB;
            
            // B -> A: Link the second node back to the first node
            nodeB.next = nodeA;
            
            // A -> C: Link the first node (now second) to the rest of the list
            nodeA.next = nodeC;
            
            // 3. Advance 'prev' to Node A (the end of the newly swapped pair) 
            // to prepare for the next iteration.
            prev = nodeA;
        }

        // The head of the new list is the node after the dummy
        return dummy.next;
    }
}