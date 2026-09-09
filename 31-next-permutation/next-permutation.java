class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;//size of array
        int i = n - 1;
        while (i >0 && nums[i] <= nums[i - 1] ) {//first decreasing element from right
            i--;
        }

        //If such an element exists, find next greater element and swap
        if(i != 0) {
            int index = i;
            for (int j = n - 1; j >= i; j--){
                if(nums [j] > nums[i - 1]) {
                    index = j;
                    break;
                }
            } 
            swap(nums, i - 1, index);
        }

            reverse(nums, i, n - 1);
        }
            private void swap(int nums[], int i, int j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

            }
            private void reverse(int nums[], int left, int right){
                while(left < right){
                    swap(nums, left, right);
                    left++;
                    right--;
                }
            }

}