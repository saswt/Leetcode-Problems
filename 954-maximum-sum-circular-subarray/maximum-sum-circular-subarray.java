//asked in Amazon, Microsoft
//Sum == -3
//minSum == -3
//maxSum == -1
//circularSum == totalSum - minSum
//if(maxSum > 0) return max(maxSum, circSum)
//else return maxSum

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        int currMin = nums[0];
        int minSum = nums[0];

        int currMax = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < n; i++) {
            currMin = Math.min(nums[i] + currMin, nums[i]);
            minSum = Math.min(minSum, currMin);

            currMax = Math.max(nums[i] + currMax, nums[i]);
            maxSum = Math.max(maxSum, currMax);
            }
            int circularSum = totalSum - minSum;
            if(maxSum > 0){
                return Math.max(maxSum, circularSum);
            }
            return maxSum;
        }
    }