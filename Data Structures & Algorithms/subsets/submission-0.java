class Solution {
    List<Integer> current = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        solve(nums, 0);
        return ans;
    }

    public void solve(int[] nums, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        solve(nums, index + 1);
        current.add(nums[index]);
        solve(nums, index + 1);
        current.remove(current.size() - 1);
    }
}
