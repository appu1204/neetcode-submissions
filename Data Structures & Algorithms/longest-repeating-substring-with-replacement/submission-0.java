class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int i = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int j = 0; j < s.length(); j++) {
            count[s.charAt(j)-'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(j)-'A']);

            while ((j - i + 1) - maxFreq > k) {
                count[s.charAt(i) - 'A']--;
                i++;
            }
            maxLen = Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }
}
