class Solution {
    public int missingMultiple(int[] nums, int k) {
     Set<Integer> st = new HashSet<>(); // to keep all elements occuring in nums
     for (int i : nums) {
        st.add(i); //adding elements to set
     }   
     int val = k; //checking value
     while(st.contains(val)) {
        val += k;
     }
     return val;
    }
}