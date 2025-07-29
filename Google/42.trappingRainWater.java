class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        int maxL = height[0];
        for(int i=1; i<height.length; i++){
            maxL = Math.max(maxL, height[i]);
            leftMax[i] = maxL;
        }
        int maxR = height[height.length-1];
        rightMax[height.length-1] = maxR;
        for(int j=height.length-2; j>=0; j--){
            maxR = Math.max(maxR, height[j]);
            rightMax[j] = maxR;
        }
        int trappedWater = 0;
        for(int k=0; k<height.length; k++){
            trappedWater+=Math.abs(height[k]-(Math.min(leftMax[k],rightMax[k])));
        }
        return trappedWater;
    }
}



