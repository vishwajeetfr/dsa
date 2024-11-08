/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start

class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0; // Pointer for the position to place the next non-val element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i]; // Place non-val element at the current index
                index++; // Move index for the next position
            }
        }
        return index; // The number of elements remaining after removal
    }
}

// @lc code=end

