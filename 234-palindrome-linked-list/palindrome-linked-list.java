//Step 1: Base Case: empty list or single node is always a plaindrome
//Step 2: Initilaize pointers: 
        // slow-> moves 1 step at a time
        // fast-> moves 2 steps at a time
        // prev-> builds the reversed first half
//Step 3: revrse the first half WHILE finding the middle
        //Loop runs until fast reaches the end of the list 
        // moves 2 step ahead at a time  
        // save next node before breaking the link
        // reverse the current node's pointer
        // moves prev forward
        // moves slow forward(using Saved Node)
// Step 4: if list has odd length, fast != null here 
        // Skip the middle element, since it doesn't affect the palindrome check
// Step 5: compare reversed first half(slow) with second half(slow)
        // mismatch found-> not a palindrome
//Step 6: all values matched
class Solution {
    public boolean isPalindrome(ListNode head) {
        //Step 1: Base Case: empty list or single node is always a plaindrome
        if(head == null || head.next == null) {
            return true;
        }

        //Step 2: Initilaize pointers: 
        // slow-> moves 1 step at a time
        // fast-> moves 2 steps at a time
        // prev-> builds the reversed first half
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        //Step 3: revrse the first half WHILE finding the middle
        //Loop runs until fast reaches the end of the list
        while(fast != null && fast.next != null) {
            fast = fast.next.next; // moves 2 step ahead at a time

            ListNode temp = slow.next; // save next node before breaking the link
            slow.next = prev; // reverse the current node's pointer
            prev = slow; // moves prev forward
            slow = temp; // moves slow forward(using Saved Node)
        }
        // Step 4: if list has odd length, fast != null here 
        // Skip the middle element, since it doesn't affect the palindrome check
        if(fast != null)
        slow = slow.next;
        // Step 5: compare reversed first half(slow) with second half(slow)
        while(prev != null && slow != null) {
            if(prev.val != slow.val) {
                return false; // mismatch found-> not a palindrome
            }
            prev = prev.next;
            slow = slow.next;
        }

        //Step 6: all values matched
        return true;
    }
}