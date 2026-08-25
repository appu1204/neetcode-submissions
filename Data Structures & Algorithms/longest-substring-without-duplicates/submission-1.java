class Solution {
    public int lengthOfLongestSubstring(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        
        int i = 0;
        int j = 0;
        int maxLen = 0;
        while (j < s.length()) {
            if (!deque.contains(s.charAt(j))) {
                deque.add(s.charAt(j));
                j++;
            } else {
                deque.removeFirst();
                i++;

            }
            maxLen = Math.max(maxLen, deque.size());
        }
        return maxLen;
    }
}
