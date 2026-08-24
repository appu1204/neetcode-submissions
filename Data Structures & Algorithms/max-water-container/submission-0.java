class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;
        int left = 0;
        int right = heights.length-1;

        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            int currWater = height * width;
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
            maxWater = Math.max(maxWater, currWater);
        }
        return maxWater;
    }
}
