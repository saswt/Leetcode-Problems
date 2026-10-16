class Solution {
    int n;
    int[][] t = new int[1001][201];
    public int solve(int idx, int[] nums, int target) {
        if(target == 0)
            return 1;
            if(idx >= n || target < 0)
                return 0;
                if(t[target][idx] != -1) 
                    return t[target][idx];
                
                int result = 0;

                for(int i = idx; i < n; i++) {
                    int take = solve(0, nums, target - nums[i]);
                    result += take;
                }
                return t[target][idx] = result;
    }
    public int combinationSum4(int[] nums, int target) {
        n = nums.length;
        for(int i = 0; i <= 1000; i++) {
            Arrays.fill(t[i], -1);
        }
        return solve(0, nums, target);
        
    }
}