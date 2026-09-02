public class Solution {
    private List<List<Integer>> result = new ArrayList<>();//stores all subsets

    public List<List<Integer>> subsets(int[] nums) {//entry point
        List<Integer> temp = new ArrayList<>();//empty list temp to build one subset
        solve(nums, 0, temp);//starts recursion from index 0 
        return result;//returns all subsets stored in result     
    }

    private void solve(int[] nums, int idx, List<Integer> temp) {
        if (idx >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        solve(nums, idx + 1, temp);
        temp.remove(temp.size() - 1);
        solve(nums, idx + 1, temp);
    }
}


//TC: O(n * 2^n)
//SC: O(n)
