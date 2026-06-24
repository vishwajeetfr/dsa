/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<TreeNode, Integer[]> memo = new HashMap<>();

    public int rob(TreeNode root) {
        return Math.max(getSol(root, true), getSol(root, false));
    }

    int getSol(TreeNode root, boolean took){
        if(root==null) return 0;
        int i = took ? 0 : 1;
        if(memo.containsKey(root) && memo.get(root)[i]!=null) return memo.get(root)[i];
        int take = 0;
        int skip = 0;
        if(!took){
            take = root.val + getSol(root.left, true) + getSol(root.right, true);
        }
        skip = getSol(root.left, false) + getSol(root.right, false);
        Integer[] ar = memo.getOrDefault(root, new Integer[2]);
        ar[i] = Math.max(take, skip);
        memo.put(root, ar); 
        return ar[i];
    }

}
