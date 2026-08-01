class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int limit = max << 1;

        boolean[] pairXor = new boolean[limit];
        for (int a : nums) {
            for (int b : nums) {
                pairXor[a ^ b] = true;
            }
        }

        boolean[] ans = new boolean[limit];
        for (int x = 0; x < limit; x++) {
            if (pairXor[x]) {
                for (int num : nums) {
                    ans[x ^ num] = true;
                }
            }
        }

        int count = 0;
        for (boolean exists : ans) {
            if (exists) count++;
        }

        return count;
    }
}