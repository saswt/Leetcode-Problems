//optimized Approach
//first we will check we have to change parity of nums1
//if it changes, subtraction is only allowed with a smaller element
//condition: 1st element(or minEl)%2 ==1
//1st element is odd, retrun true kar denge

class Solution {
    public boolean uniformArray(int[] nums1) {
        int minEl = Integer.MAX_VALUE;
        for (int num : nums1) {
            minEl = Math.min(minEl, num);
        }
        if(minEl % 2 == 1) { //fist element is odd
            return true; //all nums2 will become odd
        }
        //we hav to check whether we can make all evens in nums2
        for(int num : nums1)
        if(num % 2 == 1) {
            return false;
        }
        return true;
    }
}