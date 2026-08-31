class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = 0, max = 0;
        //Find positions of max and min
        for(int i = 1; i < n; i++) {
            if(nums[i] < nums[min])min = i;
            if(nums[i] > nums[max])max = i;
        }
        //Make min the left position and max the right position
        int left = Math.min(min, max);
        int right = Math.max(min, max);
        //Checking if we remove both from front
        int fromFront = right + 1;
        //checking if we remove both from right
        int fromBack = n - left;
        //condition if we remove both separately
        int bothSides = (left + 1) + (n - right);
        return Math.min(fromFront, Math.min(fromBack, bothSides));
 
        }
    }
    //Brute Force Method