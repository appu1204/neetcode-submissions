class Pair {
    int val;
    int index;

    Pair(int val, int index) {
        this.val = val;
        this.index = index;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Pair> st = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();

        int n = temperatures.length - 1;

        for (int i = n; i >= 0; i--) {

            if (st.isEmpty()) {
                res.add(-1);
            } 
            else if (temperatures[i] < st.peek().val) {
                res.add(st.peek().index);
            } 
            else {
                while (!st.isEmpty() && st.peek().val <= temperatures[i]) {
                    st.pop();
                }

                if (st.isEmpty()) {
                    res.add(-1);
                } 
                else {
                    res.add(st.peek().index);
                }
            }

            st.push(new Pair(temperatures[i], i));
        }

        reverse(res);

        int[] result = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) == -1) {
                result[i] = 0;
            } else {
                result[i] = res.get(i) - i;
            }
        }

        return result;
    }

    public void reverse(ArrayList<Integer> res) {
        int left = 0;
        int right = res.size() - 1;

        while (left < right) {
            int temp = res.get(left);
            res.set(left, res.get(right));
            res.set(right, temp);

            left++;
            right--;
        }
    }
}