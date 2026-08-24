class Solution {
    public int trap(int[] height) {
        int lmax = 0;
        int rmax = 0;
        int left = 0;
        int right = height.length-1;
        int total = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (lmax > height[left]) {
                    total += lmax - height[left];
                } else {
                    lmax = height[left];
                }
                left += 1;
            } else {
                if (rmax > height[right]) {
                    total += rmax - height[right];
                } else {
                    rmax = height[right];
                }
                right -= 1;
            }
        }
        return total;
    }
}
