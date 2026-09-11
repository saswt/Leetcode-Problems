class Solution {
    public int totalNumbers(int[] digits) {
        // Step 1: Count the frequency of each digit in our pool
        int[] available = new int[10];
        for (int d : digits) {
            available[d]++;
        }
        
        int count = 0;
        
        // Step 2: Iterate through all possible 3-digit even numbers
        for (int num = 100; num <= 998; num += 2) {
            int h = num / 100;       // Hundreds place
            int t = (num / 10) % 10; // Tens place
            int o = num % 10;        // Ones place
            
            // Count what digits are required for this specific number
            int[] required = new int[10];
            required[h]++;
            required[t]++;
            required[o]++;
            
            // Verify if we have enough available digits to form this number
            if (available[h] >= required[h] && 
                available[t] >= required[t] && 
                available[o] >= required[o]) {
                count++;
            }
        }
        
        return count;
    }
}
