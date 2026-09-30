class Solution {

    // Stores all permutations
    List<List<Integer>> result = new ArrayList<>();

    // Keeps track of visited elements
    HashSet<Integer> st = new HashSet<>();

    int n;

    public void solve(List<Integer> temp, int[] nums) {

        // Base Case
        if (temp.size() == n) {
            result.add(new ArrayList<>(temp)); // Store a copy
            return;
        }

        // Try every element
        for (int i = 0; i < n; i++) {

            // If current element is not used
            if (!st.contains(nums[i])) {

                temp.add(nums[i]);
                st.add(nums[i]);

                solve(temp, nums);

                // Backtracking
                st.remove(nums[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        n = nums.length;

        List<Integer> temp = new ArrayList<>();

        solve(temp, nums);

        return result;
    }
}