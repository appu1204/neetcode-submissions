class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int[] count = new int[26];

        for (int i = 0; i < n; i++) {
            count[s1.charAt(i) - 'a']++;
        }

        int j = 0;
        int i = 0;

        while (j < s2.length()) {
            count[s2.charAt(j) - 'a']--;

            if (j-i+1 == n) {
                boolean valid = true;
                for (int k = 0; k < 26; k++) {
                    if (count[k] != 0) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    return true;
                }
                count[s2.charAt(i)-'a']++;
                i++;
            }
            j++;
        }
        return false;
    }
}
