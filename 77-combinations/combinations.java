//Approach 1: without using for loop
//Approach 2: using for loop(more optimised solution).

import java.util.*;
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public void solve(int start, int n, int k, List<Integer>temp){
        if(k == 0) {
            result.add(new ArrayList<>(temp));
            return;
    }
    if (start > n) {
        return;
    }
    temp.add(start);
    solve(start + 1, n, k - 1, temp);

    temp.remove(temp.size() - 1);

    solve(start + 1, n, k, temp);
  }

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        solve (1, n, k, temp);
        return result;
        
    }
}