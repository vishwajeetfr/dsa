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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode node : lists) {
        while (node != null) {
         pq.add(node.val);  
         node = node.next;  
        }
        }
        ListNode sol = new ListNode();
        while(!pq.isEmpty()){
        ListNode curr = sol;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = new ListNode(pq.poll());
        }
        return sol.next;
    }
}
