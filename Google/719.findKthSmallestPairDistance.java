class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countPairs(nums, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    
    private int countPairs(int[] nums, int mid) {
        int count = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > mid) {
                left++;
            }
            count += right - left;
        }
        return count;
    }
}
