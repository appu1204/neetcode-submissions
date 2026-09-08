class Pair {
    int val;
    int index;

    Pair(int val, int index) {
        this.val = val;
        this.index = index;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {

        ArrayList<Integer> nsr = nser(heights);
        ArrayList<Integer> nsl = nsel(heights);

        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int width = nsr.get(i) - nsl.get(i) - 1;
            int area = width * heights[i];

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public ArrayList<Integer> nser(int[] heights) {

        int lastIndex = heights.length;
        int n = heights.length;

        Deque<Pair> st = new ArrayDeque<>();
        ArrayList<Integer> nsr = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek().val >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nsr.add(lastIndex);
            } else {
                nsr.add(st.peek().index);
            }

            st.push(new Pair(heights[i], i));
        }

        return reverse(nsr);
    }

    public ArrayList<Integer> nsel(int[] heights) {

        int startIndex = -1;
        int n = heights.length;

        Deque<Pair> st = new ArrayDeque<>();
        ArrayList<Integer> nsl = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && st.peek().val >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nsl.add(startIndex);
            } else {
                nsl.add(st.peek().index);
            }

            st.push(new Pair(heights[i], i));
        }

        return nsl;
    }

    public ArrayList<Integer> reverse(ArrayList<Integer> nsr) {

        int left = 0;
        int right = nsr.size() - 1;

        while (left < right) {

            int temp = nsr.get(left);
            nsr.set(left, nsr.get(right));
            nsr.set(right, temp);

            left++;
            right--;
        }

        return nsr;
    }
}