import java.util.*;
class Solution{
    int n;
    int minSum = Integer.MAX_VALUE;
    List<Integer> result = new ArrayList<>();

    public void solve(int [] nums, boolean[] visited, List<Integer> temp, int sum) {

        if(sum >= minSum) {
            return;
        }
        if(temp.size() == n) {
            sum += Math.abs(temp.get(temp.size() - 1) - nums[temp.get(0)]);

            if(sum < minSum) {
                minSum = sum;
                result = new ArrayList<>(temp);
            }
            return;
        }
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp.add(i);

                int last = temp.size() - 1;
                int newSum = sum + Math.abs(temp.get(last - 1) - nums[temp.get(last)]);

                solve(nums, visited, temp, newSum);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }
    public int[] findPermutation(int[] nums) {
        n = nums.length;
        boolean[] visited = new boolean[n];
        List<Integer> temp = new ArrayList<>();

        temp.add(0);
        visited[0] = true;

        solve(nums, visited, temp, 0);

        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}