class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count1 = 0;  // Number of elements less than target
        int count2 = 0;  // Number of elements equal to target
        for (int num : nums) {
            if (num < target)
                count1++;
            else if (num == target)
                count2++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = count1; i < count1 + count2; i++) {
            result.add(i);
        }
        return result;
    }
}