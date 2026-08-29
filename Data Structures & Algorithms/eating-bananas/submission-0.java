class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = maxElements(piles);
        int ans = high;

        while (low <= high) {
            int mid = low + (high-low) / 2;
            long totalTime = minBanana(piles, mid);
            if (totalTime <= h) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int maxElements(int[] piles) {
        int maxPile = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > maxPile) {
                maxPile = piles[i];
            }
        }
        return maxPile;
    }

    public long minBanana(int[] piles, int mid) {
        long totalTime = 0;
        for (int i = 0; i < piles.length; i++) {
            long onePile = (piles[i] + (long)mid -1) / mid;
            totalTime += onePile;
        }
        return totalTime;
    }
}
