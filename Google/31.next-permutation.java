/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// Difficulty : Medium
// Related Topics : Array
// Problem Link : https://leetcode.com/problems/next-permutation/

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        
        // Step 1: Find the first decreasing element from the end
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        if (i >= 0) {
            int j = nums.length - 1;
            
            // Step 2: Find the first element larger than nums[i]
            while (nums[j] <= nums[i]) {
                j--;
            }
            
            // Step 3: Swap elements at i and j
            swap(nums, i, j);
        }
        
        // Step 4: Reverse the subarray from i+1 to the end
        reverse(nums, i + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}

// @lc code=end

// EXPLAINATION

// Find the Pivot: Traverse the array from the end to find the first position i where nums[i] < nums[i + 1]. This marks the point where we can increase the permutation to get the next lexicographical order.

// Find the Element to Swap: From the end of the array, find the smallest element nums[j] that's greater than nums[i]. This ensures the smallest possible increase.

// Swap nums[i] and nums[j]: Swap these elements to set up the next permutation.

// Reverse the Suffix: Reverse the subarray from i + 1 to the end to make it the smallest lexicographical order.

