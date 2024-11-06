/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
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

 // problem link - https://leetcode.com/problems/add-two-numbers-ii/
 // related topics - Linked List, Stack , Math
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      Deque<ListNode> stack1 = new ArrayDeque<>();
      Deque<ListNode> stack2 = new ArrayDeque<>();
  
      while (l1 != null) {
        stack1.push(l1);
        l1 = l1.next;
      }
  
      while (l2 != null) {
        stack2.push(l2);
        l2 = l2.next;
      }
  
      ListNode head = null;
      int carry = 0;
  
      while (carry > 0 || !stack1.isEmpty() || !stack2.isEmpty()) {
        if (!stack1.isEmpty())
          carry += stack1.pop().val;
        if (!stack2.isEmpty())
          carry += stack2.pop().val;
        ListNode node = new ListNode(carry % 10);
        node.next = head;
        head = node;
        carry /= 10;
      }
  
      return head;
    }
  }
// @lc code=end

// Explanation:
// Use of Stacks:

// The solution uses two stacks (stack1 and stack2) to store the nodes of the two linked lists. This allows for adding numbers from the most significant digit (the leftmost node) to the least significant digit (the rightmost node), effectively reversing the linked list's natural traversal order.
// Each node is pushed onto a stack, so the last node (least significant digit) becomes the top of the stack and can be processed first.
// Push Nodes onto Stacks:

// Traverse l1 and push each node onto stack1.
// Traverse l2 and push each node onto stack2.
// Adding Digits with Carry:

// The algorithm initializes carry to 0 and head to null.
// It processes nodes from both stacks while there are still nodes left in either stack or there is a non-zero carry.
// If stack1 is not empty, the top node's value is added to carry and popped from the stack.
// Similarly, if stack2 is not empty, the top node's value is added to carry and popped from the stack.
// A new node is created with the value carry % 10 (the current digit), and the carry is updated as carry / 10 to prepare for the next higher digit.
// The new node is linked by setting node.next to the current head, effectively inserting it at the front of the result list.
// Updating Head:

// The head pointer is updated to point to the new node, so the list grows from the most significant digit to the least significant.
// Final Return:

// After the loop finishes, head points to the start of the result linked list, which is returned.

