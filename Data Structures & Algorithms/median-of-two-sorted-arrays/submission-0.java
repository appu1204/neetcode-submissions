class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num = sortedArray(nums1, nums2);

        int left = 0;
        int right = num.length-1;
        int len = num.length;
        double ans = 0.0;

        if (len == 1) {
            ans = num[0];
        }

        if (len % 2 == 0) {
            int mid = (left + right) / 2;
            ans = (double)(num[mid] + num[mid+1]) / 2;
        } 
        
        else {
            int mid = (left + right) / 2;
            ans = num[mid];
        }
        return ans;

    }
    public int[] sortedArray(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] arr = new int[m + n];

        int i = 0;
        int j = 0;
        int index = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                arr[index++] = nums1[i];
                i++;
            } else {
                arr[index++] = nums2[j];
                j++;
            }
        }

        while (i < m) {
            arr[index++] = nums1[i];
            i++;
        }

        while (j < n) {
            arr[index++] = nums2[j];
            j++;
        }
        return arr;
    }
}
