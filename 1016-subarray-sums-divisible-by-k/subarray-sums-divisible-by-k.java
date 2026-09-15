//optimized solution using map
//map is getting used for the value of reaminder(one side count i.e. frequency) and other side value of remainder
//Brute Force and Better Solution is not possible, since it will reach TLE(Time Limit Exceeded)m due to high constraints.
//only optimal solution will give us answer using map only
//This question has been asked in PAYTM, AMAZON, MICROSOFT.

import java.util.HashMap;
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Stores: remainder -> how many times this remainder has appeared
        int sum = 0;
        int result = 0;
         // Remainder 0 has already occurred once (empty subarray)
        map.put(0, 1); // put(key, value) -> Insert a key-value pair

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if(rem < 0){ // Handle negative remainders
                rem += k;
            }
             // Check whether this remainder has appeared before
            if (map.containsKey(rem)) { // containsKey(key) -> Returns true if key exists

             // Add the frequency of this remainder to answer
                result += map.get(rem); // get(key) -> Returns value stored at key
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
             // getOrDefault(key, defaultValue)
            // If key exists -> return its value
            // Else -> return defaultValue (0 here)
        }
         return result;
    }
}