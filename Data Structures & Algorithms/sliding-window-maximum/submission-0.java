class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();

        int i = 0;
        int j = 0;
        int index = 0;

        while (j < n) {
            if (!dq.isEmpty() && dq.peekFirst() < i) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[j]) {
                dq.pollLast();
            }

            dq.offerLast(j);

            if (j-i+1 == k) {
                res[index++] = nums[dq.peekFirst()];
                i++;
            }
            j++;
        }
        return res;
    }
}
