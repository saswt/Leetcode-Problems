class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        
        int resultXor = 0; // stores XOR of all elements in the array
        boolean allZero = true; // tracks whether every element is zero 

        // Step 1: Compute XOR of the entire array in one pass
        // Also check if all elements are zero
        for (int x : nums) {
        resultXor ^= x;
        if (x != 0)
        allZero = false;
        }
        // Step 2: If every element is 0, XOR of ANY subsequence will always be 0
        // So no valid non-zero XOR subsequence exists -> return 0

        if(allZero)
        return 0;
        // Step 3: Decide answer based on XOR of the whole array
        // - If total XOR != 0 -> the entire array already has non-zero XOR,
        //   so the whole array (length n) is the answer
        // - If total XOR == 0 -> we must drop exactly one non-zero element
        //   to flip the XOR to non-zero, so the best length is n - 1
    return resultXor == 0 ? n - 1 : n;
  
    }
};