//Brute Force bhut jyada iteration hota, isiliye Brute force nhi bna skte the
//Map ka use krke banaenge
//initially map me (0, -1) denote krega (remiander, index) ko
//fir map ke thorugh har value ko check krenge

import java.util.HashMap;
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];
            int remainder = sum % k;

            //check if it's find in map(past me khi pe dekha hai ya nhi)
            if(map.containsKey(remainder)) {
                if(i - map.get(remainder) >= 2){
                    return true;
                }
            }
            else{
                map.put(remainder, i);
            }
        }
        return false;

    }
}