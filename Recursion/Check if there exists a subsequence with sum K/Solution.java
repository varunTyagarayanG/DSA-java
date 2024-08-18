class Solution {
    public boolean helper(int idx, int[] nums, int k) {
        // Base cases
        if (k == 0) {
            return true; // Found a subsequence that sums up to k
        }
        if (k < 0 || idx >= nums.length) {
            return false; // No valid subsequence found
        }

        // Recursive cases:
        // 1. Include the current element in the subsequence
        // 2. Exclude the current element and move to the next
        boolean path1 = helper(idx + 1, nums, k - nums[idx]);
        boolean path2 = helper(idx + 1, nums, k);

        return path1 || path2;
    }

    public boolean checkSubsequenceSum(int[] nums, int k) {
        return helper(0, nums, k);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 2, 3, 4, 5};
        int k1 = 9;
        System.out.println("Test Case 1: " + solution.checkSubsequenceSum(nums1, k1)); 

        // Test case 2
        int[] nums2 = {1, 2, 3, 4, 5};
        int k2 = 11;
        System.out.println("Test Case 2: " + solution.checkSubsequenceSum(nums2, k2)); 

        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 5};
        int k3 = 100;
        System.out.println("Test Case 3: " + solution.checkSubsequenceSum(nums3, k3)); 

        // Test case 4
        int[] nums4 = {5, 5, 5};
        int k4 = 10;
        System.out.println("Test Case 4: " + solution.checkSubsequenceSum(nums4, k4)); 

        // Test case 5
        int[] nums5 = {1, 2, 3};
        int k5 = 6;
        System.out.println("Test Case 5: " + solution.checkSubsequenceSum(nums5, k5)); 
    }
}
